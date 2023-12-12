package com.example.statisticservice.service;

import com.example.statisticservice.queue.model.StatisticModel;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class StatisticService {

    private final Map<Integer, List<StatisticModel>> formulaToStatistic = new TreeMap<>();

    public Map<Integer, List<StatisticModel>> getStatistic() {
        return formulaToStatistic;
    }

    public List<StatisticModel> getStatisticByFormulaId(Integer formulaId) {
        if (formulaId == null || !formulaToStatistic.containsKey(formulaId)) {
            throw new IllegalArgumentException("Statistic not found");
        }
        return formulaToStatistic.get(formulaId);
    }

    @EventListener
    public void addStatistic(StatisticModel statisticModel) {
        formulaToStatistic.computeIfAbsent(statisticModel.getFormulaId(), k -> new ArrayList<>()).add(statisticModel);
    }
}
