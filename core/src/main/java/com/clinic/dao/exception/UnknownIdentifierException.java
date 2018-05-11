package com.clinic.dao.exception;

public class UnknownIdentifierException extends RuntimeException {
    public UnknownIdentifierException() {
        super();
    }

    public UnknownIdentifierException(String message) {
        super(message);
    }
}
