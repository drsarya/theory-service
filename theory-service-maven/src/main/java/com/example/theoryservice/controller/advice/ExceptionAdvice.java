package com.example.theoryservice.controller.advice;

import com.example.theoryservice.model.basic.ErrorModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.ConnectException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<ErrorModel> handleInternalException(ConnectException e) {
        log.error(e.getMessage(), e);
        var errorModel = new ErrorModel("ConnectException", e.getMessage());
        return ResponseEntity.status(INTERNAL_SERVER_ERROR.value()).body(errorModel);
    }
}
