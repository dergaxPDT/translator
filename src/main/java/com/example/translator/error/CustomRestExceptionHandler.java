package com.example.translator.error;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler
        extends ResponseEntityExceptionHandler {

    private static Logger logger = LogManager.getLogger(CustomRestExceptionHandler.class);


    @ExceptionHandler(value
            = { NullPointerException.class })
    protected ResponseEntity<Object> handleNotFound(
            RuntimeException ex, WebRequest request) {
        logger.error(ex);
        String  bodyOfResponse = "Error: " + ex;
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}