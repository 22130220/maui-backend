package com.example.demo.handler;

import com.example.demo.config.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseApi<Void>> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseApi<>(ResponseStatus.NOT_FOUND, null));
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseApi<Void>> handleBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseApi<>(ResponseStatus.BAD_REQUEST  ,  null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseApi<Void>> handleException(Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseApi<>(ResponseStatus.INTERNAL_SERVER_ERROR, null));
    }
}
