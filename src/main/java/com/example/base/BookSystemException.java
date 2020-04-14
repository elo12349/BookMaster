package com.example.base;

public class BookSystemException extends RuntimeException {
    public BookSystemException(String messageCode) {
        super(messageCode);
    }
}
