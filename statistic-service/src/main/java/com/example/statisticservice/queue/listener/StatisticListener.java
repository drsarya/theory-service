package com.example.statisticservice.queue.listener;

import com.example.statisticservice.queue.model.StatisticModel;
import com.example.statisticservice.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StatisticListener {

    private final StatisticService statisticService;

    public StatisticListener(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @EventListener
    public void processStatistic(StatisticModel statisticModel) {
        log.info("Process statistic {}", statisticModel);
        statisticService.addStatistic(statisticModel);
    }
}
