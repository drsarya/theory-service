package com.example.statisticservice.queue.model;

import lombok.Data;

import java.time.Instant;

@Data
public class StatisticModel {

    private final Integer formulaId;
    private final String formulaName;
    private final Instant date;
}
