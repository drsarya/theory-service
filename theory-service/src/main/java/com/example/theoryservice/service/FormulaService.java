package com.example.theoryservice.service;

import com.example.theoryservice.model.FormulaModel;
import com.example.theoryservice.model.RatingModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class FormulaService {

    private final RestTemplate restTemplate;

    public FormulaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FormulaModel getFormulaById(Integer formulaId) {
        ResponseEntity<RatingModel> exchange = restTemplate.exchange("/formula-rating/formula/{id}",
                HttpMethod.GET, null, RatingModel.class, formulaId);
        String description = "T(1) - B * T(1) = (1 - B) * T(1) равняется времени, необходимому для исполнения той части программы, которая способна исполняться параллельно с одним процессором: Тогда (1 - B) * T(1) / N это то время, которое потребляет исполнение данной части с N процессорами.";
        String name = "Закон Амдала";
        return new FormulaModel(formulaId, name, description, exchange.getBody());
    }
}
