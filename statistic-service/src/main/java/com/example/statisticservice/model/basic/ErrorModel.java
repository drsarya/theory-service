package com.example.statisticservice.model.basic;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class ErrorModel {

    private String exception;

    private String message;
}
