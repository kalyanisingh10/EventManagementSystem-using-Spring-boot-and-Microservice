package com.example.eventms.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserGlobalException  {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<String> handleUserExistException(UserAlreadyExistException ex){

        return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);


    }


}
