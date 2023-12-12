package com.example.statisticservice.controller;

import com.example.statisticservice.queue.model.StatisticModel;
import com.example.statisticservice.service.StatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/formulas")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping
    public Map<Integer, List<StatisticModel>> getStatistic() {
        return statisticService.getStatistic();
    }

    @GetMapping("/{formulaId}")
    public List<StatisticModel> getStatisticByFormulaId(@PathVariable Integer formulaId) {
        return statisticService.getStatisticByFormulaId(formulaId);
    }
}
