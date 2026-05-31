package com.fpolizzi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by fpolizzi on 5/31/26
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {

        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {

        super(message, cause);
    }
}
