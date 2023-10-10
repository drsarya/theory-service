package com.example.theoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FormulaModel {

    private Integer formulaId;
    private String name;
    private String description;
    private RatingModel ratingModel;
}
