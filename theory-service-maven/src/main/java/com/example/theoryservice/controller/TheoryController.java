package com.example.theoryservice.controller;

import com.example.theoryservice.model.FormulaModel;
import com.example.theoryservice.service.FormulaService;
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
