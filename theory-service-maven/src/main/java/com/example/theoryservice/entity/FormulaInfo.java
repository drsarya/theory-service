package com.example.theoryservice.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class FormulaInfo {
    private String formula;
    private Set<String> variables;
}
