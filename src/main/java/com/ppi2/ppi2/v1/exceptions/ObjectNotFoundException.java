package com.ppi2.ppi2.v1.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException() {
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
