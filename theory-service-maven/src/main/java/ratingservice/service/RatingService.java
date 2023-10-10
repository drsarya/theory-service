package ratingservice.service;

import org.springframework.stereotype.Service;
import ratingservice.model.RatingModel;

import java.util.Random;

@Service
public class RatingService {

    private final Random random = new Random();

    public RatingModel getRatingByFormulaId(Integer formulaId) {
        return new RatingModel(formulaId, Math.abs(random.nextInt()));
    }
}
