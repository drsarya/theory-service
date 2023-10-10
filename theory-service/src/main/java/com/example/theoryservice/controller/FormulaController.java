package com.example.theoryservice.controller;

import com.example.theoryservice.model.FormulaModel;
import com.example.theoryservice.service.FormulaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formulas")
public class FormulaController {
    private final FormulaService formulaService;

    public FormulaController(FormulaService formulaService) {
        this.formulaService = formulaService;
    }


    @GetMapping("/{formulaId}")
    public FormulaModel getRating(@PathVariable Integer formulaId) {
        return formulaService.getFormulaById(formulaId);
    }
}
