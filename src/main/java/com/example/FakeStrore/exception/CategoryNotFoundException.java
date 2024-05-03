package com.example.FakeStrore.exception;

public class CategoryNotFoundException extends ProductPresentException{

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
