package com.example.theoryservice.controller;

import com.example.theoryservice.model.FormulaModel;
import com.example.theoryservice.model.create.FormulaCreateModel;
import com.example.theoryservice.service.FormulaService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/formulas")
public class TheoryController {

    private final FormulaService formulaService;

    public TheoryController(FormulaService formulaService) {
        this.formulaService = formulaService;
    }

    @PostMapping
    public FormulaModel createFormula(@RequestBody FormulaCreateModel createModel) {
        return formulaService.createFormula(createModel);
    }

    @PostMapping("/{formulaId}/calculate")
    public Double calculateFormula(@PathVariable Integer formulaId, @RequestBody Map<String, Double> parameters) {
        return formulaService.calculateFormula(formulaId, parameters);
    }

    @GetMapping("/{formulaId}")
    public FormulaModel getFormulaInfo(@PathVariable Integer formulaId) {
        return formulaService.getFormulaById(formulaId);
    }

    @GetMapping("/delay")
    public FormulaModel getFormulaInfoWithDelay() throws InterruptedException {
        System.out.println("Start get rating");
        Thread.sleep(60_000);
        return null;
    }

    @GetMapping("/exception")
    public FormulaModel getFormulaInfoWithException() {
        System.out.println("Start get rating");
        throw new IllegalArgumentException("Throw new exception");
    }
}
