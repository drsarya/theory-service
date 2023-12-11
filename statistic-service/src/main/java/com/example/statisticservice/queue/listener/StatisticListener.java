package com.example.statisticservice.queue.listener;

import com.example.statisticservice.queue.model.StatisticModel;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
public class StatisticListener {

    private final Map<Integer, List<StatisticModel>> formulaToStatistic = new TreeMap<>();

    @EventListener
    public void processStatistic(StatisticModel statisticModel) {
        formulaToStatistic.computeIfAbsent(statisticModel.getFormulaId(), k -> new ArrayList<>()).add(statisticModel);
    }
}
