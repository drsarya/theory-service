package com.example.ratingservicemaven.controller;

import com.example.ratingservicemaven.model.FormulaModel;
import com.example.ratingservicemaven.service.FormulaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formulas")
public class TheoryController {
    private final FormulaService formulaService;

    public TheoryController(FormulaService formulaService) {
        this.formulaService = formulaService;
    }


    @GetMapping("/{formulaId}")
    public FormulaModel getRating(@PathVariable Integer formulaId) {
        return formulaService.getFormulaById(formulaId);
    }
}
