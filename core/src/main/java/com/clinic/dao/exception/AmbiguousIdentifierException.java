package com.clinic.dao.exception;

public class AmbiguousIdentifierException extends RuntimeException {
    public AmbiguousIdentifierException() {
        super();
    }

    public AmbiguousIdentifierException(String message) {
        super(message);
    }
}
