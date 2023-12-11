package com.example.theoryservice.service;

import com.example.theoryservice.model.FormulaModel;
import com.example.theoryservice.queue.model.StatisticModel;
import com.example.theoryservice.queue.producer.PublisherService;
import generated.rating.library.FormulaRatingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class FormulaService {

    private final GrpcRatingClient grpcRatingClient;
    private final PublisherService publisherService;
    private final String statisticTopic;

    public FormulaService(GrpcRatingClient grpcRatingClient, PublisherService publisherService, @Value("${settings.kafka.topic}") String statisticTopic) {
        this.grpcRatingClient = grpcRatingClient;
        this.publisherService = publisherService;
        this.statisticTopic = statisticTopic;
    }

    public FormulaModel getFormulaById(Integer formulaId) {
        FormulaRatingResponse formulaRating = grpcRatingClient.getFormulaRating(formulaId);

        String description = "T(1) - B * T(1) = (1 - B) * T(1) равняется времени, необходимому для исполнения той части программы, которая способна исполняться параллельно с одним процессором: Тогда (1 - B) * T(1) / N это то время, которое потребляет исполнение данной части с N процессорами.";
        String name = "Закон Амдала";

        var statisticModel = StatisticModel.builder()
                .formulaId(formulaId)
                .date(Instant.now())
                .formulaName(name)
                .build();
        publisherService.sendMessage(statisticTopic, statisticModel, formulaId.toString());

        return new FormulaModel(formulaId, name, description, formulaRating.getRating());
    }
}