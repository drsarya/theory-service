package com.example.theoryservice.service;

import com.example.theoryservice.entity.Formula;
import com.example.theoryservice.entity.FormulaInfo;
import com.example.theoryservice.model.FormulaModel;
import com.example.theoryservice.model.create.FormulaCreateModel;
import com.example.theoryservice.queue.model.StatisticModel;
import com.example.theoryservice.queue.producer.PublisherService;
import com.example.theoryservice.repository.FormulaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import generated.rating.library.FormulaRatingResponse;
import lombok.SneakyThrows;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Map;

@Service
public class FormulaService {

    private final FormulaRepository formulaRepository;
    private final GrpcRatingClient grpcRatingClient;
    private final PublisherService publisherService;
    private final String statisticTopic;
    private final ObjectMapper objectMapper;

    public FormulaService(FormulaRepository formulaRepository,
                          GrpcRatingClient grpcRatingClient,
                          PublisherService publisherService,
                          @Value("${settings.kafka.topic}") String statisticTopic,
                          ObjectMapper objectMapper) {
        this.formulaRepository = formulaRepository;
        this.grpcRatingClient = grpcRatingClient;
        this.publisherService = publisherService;
        this.statisticTopic = statisticTopic;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    public FormulaModel getFormulaById(Integer formulaId) {
        Formula formula = formulaRepository.findById(formulaId)
                .orElseThrow(() -> new IllegalArgumentException("Formula not found"));
        FormulaRatingResponse formulaRating = grpcRatingClient.getFormulaRating(formulaId);
        FormulaInfo formulaInfo = objectMapper.readValue(formula.getFormula(), FormulaInfo.class);

        var statisticModel = StatisticModel.builder()
                .formulaId(formulaId)
                .date(Instant.now())
                .formulaName(formula.getName())
                .build();
        publisherService.sendMessage(statisticTopic, statisticModel, formulaId.toString());

        return FormulaModel
                .builder()
                .formulaId(formulaId)
                .name(formula.getName())
                .description(formula.getDescription())
                .formula(formulaInfo.getFormula())
                .variables(formulaInfo.getVariables())
                .rating(formulaRating.getRating())
                .build();
    }

    @SneakyThrows
    @Transactional
    public FormulaModel createFormula(FormulaCreateModel formulaCreateModel)  {
        var formulaInfo = FormulaInfo.builder()
                .variables(formulaCreateModel.getVariables())
                .formula(formulaCreateModel.getFormula())
                .build();
        String formulaInfoJson = objectMapper.writeValueAsString(formulaInfo);


        Formula formula = new Formula();
        formula.setName(formulaCreateModel.getName());
        formula.setFormula(formulaInfoJson);
        formula.setDescription(formulaCreateModel.getDescription());

        Formula persistFormula = formulaRepository.save(formula);
        return FormulaModel
                .builder()
                .formulaId(persistFormula.getId())
                .name(formula.getName())
                .description(formula.getDescription())
                .formula(formulaInfo.getFormula())
                .variables(formulaInfo.getVariables())
                .rating(0L)
                .build();
    }

    @SneakyThrows
    public Double calculateFormula(Integer formulaId, Map<String, Double> parameters) {
        var formula = formulaRepository.findById(formulaId)
                .orElseThrow(() -> new IllegalArgumentException("Formula not found"));

        FormulaInfo formulaInfo = objectMapper.readValue(formula.getFormula(), FormulaInfo.class);
        if (parameters.size() != formulaInfo.getVariables().size()) {
            throw new IllegalArgumentException("Formula can not be calculated");
        }

        Expression expression = new ExpressionBuilder(formulaInfo.getFormula())
                .variables(formulaInfo.getVariables())
                .build()
                .setVariables(parameters);
        return expression.evaluate();
    }
}