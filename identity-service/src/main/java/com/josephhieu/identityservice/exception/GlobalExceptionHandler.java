package com.josephhieu.identityservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<String> handlerRuntimeException(RuntimeException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<String> handerRuntimeException(MethodArgumentNotValidException exception) {

//        String errorMessage = exception.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(error -> error.getField() + ":" + error.getDefaultMessage())
//                .findFirst()
//                .orElse("Password must have 6 characters at least !!!");

        return ResponseEntity.badRequest().body(exception.getFieldError().getDefaultMessage());
    }


}
