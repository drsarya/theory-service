package com.example.ratingservicemaven.service;

import com.example.ratingservicemaven.model.FormulaModel;
import generated.rating.library.FormulaRatingResponse;
import org.springframework.stereotype.Service;

@Service
public class FormulaService {

    private final GrpcRatingClient grpcRatingClient;

    public FormulaService(GrpcRatingClient grpcRatingClient) {
        this.grpcRatingClient = grpcRatingClient;
    }

    public FormulaModel getFormulaById(Integer formulaId) {
        FormulaRatingResponse formulaRating = grpcRatingClient.getFormulaRating(formulaId);

        String description = "T(1) - B * T(1) = (1 - B) * T(1) равняется времени, необходимому для исполнения той части программы, которая способна исполняться параллельно с одним процессором: Тогда (1 - B) * T(1) / N это то время, которое потребляет исполнение данной части с N процессорами.";
        String name = "Закон Амдала";
        return new FormulaModel(formulaId, name, description, formulaRating.getRating());
    }
}