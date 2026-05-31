package com.fpolizzi.exception;

/**
 * Created by fpolizzi on 5/31/26
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {

        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {

        super(message, cause);
    }
}
