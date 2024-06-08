package com.ra.advice;

import com.ra.model.dto.respone.DataError;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DataError<Map<String,String>> handlerErrorNotValidException(MethodArgumentNotValidException exception){
        Map<String,String> map = new HashMap<>();
        exception.getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return new DataError<>(map, 400);
    }
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DataError<String> handlerErrorNotFoundElement(NoSuchElementException exception){
        return new DataError<>(exception.getMessage(),404);
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DataError<String> handlerErrorNotFound(Exception exception){
        return new DataError<>(exception.getMessage(),404);
    }
}
