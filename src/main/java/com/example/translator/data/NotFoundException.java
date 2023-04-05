package com.example.translator.data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Word is not translate yet")  // 404
public class NotFoundException extends RuntimeException  {

    public NotFoundException(String message) {
        super(message);
    }
}
