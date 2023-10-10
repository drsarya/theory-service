package com.example.ratingservice.controller;

import com.example.ratingservice.model.RatingModel;
import com.example.ratingservice.service.RatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formula-rating")
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/formula/{formulaId}")
    public RatingModel getRating(@PathVariable Integer formulaId) {
        return ratingService.getRatingByFormulaId(formulaId);
    }
}
