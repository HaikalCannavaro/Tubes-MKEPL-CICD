package com.mycompany.book.api;

public class InvalidBookException extends RuntimeException {

    public InvalidBookException(String message) {
        super(message);
    }
}