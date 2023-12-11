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

    @GetMapping("/delay/{formulaId}")
    public FormulaModel getRatingWithDelay(@PathVariable Integer formulaId) throws InterruptedException {
        System.out.println("Start get rating");
        Thread.sleep(60_000);
        return null;
    }

    @GetMapping("/exception/{formulaId}")
    public FormulaModel getRatingWithException(@PathVariable Integer formulaId) {
        System.out.println("Start get rating");
        throw new IllegalArgumentException("Exception occured");
    }
}
