package com.example.ratingservice.service;

import com.example.ratingservice.model.RatingModel;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RatingService {

    private final Random random = new Random();

    public RatingModel getRatingByFormulaId(Integer formulaId) {
        return new RatingModel(formulaId, Math.abs(random.nextInt()));
    }
}
