package com.example.product.controlleradvice;

import com.example.product.dtos.ErrorResponseDto;
import com.example.product.exceptions.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorResponseDto> handleArithematicException(){
        return new ResponseEntity<>(new ErrorResponseDto("divide by zero"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidProduct(){
        return new ResponseEntity<>(new ErrorResponseDto("Invalid Product"),HttpStatus.NOT_FOUND);
    }
}
