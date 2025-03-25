package com.liu.EdvinasSecurityTwo.exceptions.handler;

import com.liu.EdvinasSecurityTwo.exceptions.CustomException;
import com.liu.EdvinasSecurityTwo.exceptions.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerCustomException (CustomException exception){
        ErrorResponse errorResponse = new ErrorResponse(
                new Timestamp(System.currentTimeMillis()),
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
