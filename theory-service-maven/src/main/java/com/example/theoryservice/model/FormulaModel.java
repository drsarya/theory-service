package com.example.theoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class FormulaModel {

    private Integer formulaId;
    private String name;
    private String formula;
    private Set<String> variables;
    private String description;
    private Long rating;
}