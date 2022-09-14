package com.jcg.mapstruct.controller;

import MyException.CommorceNotNullException;
import MyException.ErrorResponse;
import MyException.IllegalArgException;
import MyException.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CommerceControllerAdvice {



    @ExceptionHandler({NotFoundException.class})
   public ResponseEntity<?> notFoundException(NotFoundException notFoundException)

    {
        List<String> detail =new ArrayList<>();
        detail.add(notFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("No Records Found exception",detail);
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

        @ExceptionHandler(CommorceNotNullException.class)
    public ResponseEntity<?> commerceNotNull(CommorceNotNullException commorceNotNullException)
    {
        List<String> detail = new ArrayList<>();
        detail.add(commorceNotNullException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("commorce asset cannot be empty",detail);
        return  new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
        @ExceptionHandler(IllegalArgException.class)
    public  ResponseEntity<?> illegalArgumant(IllegalArgException illegalArgException)
        {List<String> detail =new ArrayList<>();
            detail.add(illegalArgException.getMessage());
            ErrorResponse errorResponse = new ErrorResponse("Change your id number",detail);
            return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);}





}
