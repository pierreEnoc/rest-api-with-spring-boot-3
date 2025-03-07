package com.pierre.api_rest_with_spring_3.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends  RuntimeException {
    public UnsuportedMathOperationException(String message) {

    }
}
