package com.example.theoryservice.controller.advice;

import com.example.theoryservice.model.basic.ErrorModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorModel> handleInternalException(Exception e) {
        log.error(e.getMessage(), e);
        var errorModel = new ErrorModel(e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.status(BAD_REQUEST.value()).body(errorModel);
    }
}
