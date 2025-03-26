package com.liu.EdvinasSecurityTwo.exceptions.handler;

import com.liu.EdvinasSecurityTwo.exceptions.CarPartNotFoundException;
import com.liu.EdvinasSecurityTwo.exceptions.SupplierNotFoundException;
import com.liu.EdvinasSecurityTwo.exceptions.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerCarPartNotFoundException (CarPartNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(
                new Timestamp(System.currentTimeMillis()),
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerSupplierNotFoundException (SupplierNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(
                new Timestamp(System.currentTimeMillis()),
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
