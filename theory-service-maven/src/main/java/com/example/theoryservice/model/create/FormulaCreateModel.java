package com.example.theoryservice.model.create;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class FormulaCreateModel {

    private String name;
    private String description;
    private Set<String> variables;
    private String formula;
}
