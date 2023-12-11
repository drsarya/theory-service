package com.example.theoryservice.queue.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class StatisticModel {
    private final Integer formulaId;
    private final String formulaName;
    private final Instant date;
}
