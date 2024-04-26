package com.example.FakeStrore.exception;

public class NoProductPresentException extends RuntimeException {
    public NoProductPresentException(String message) {
        super(message);
    }
}
