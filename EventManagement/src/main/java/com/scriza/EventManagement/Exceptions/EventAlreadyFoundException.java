package com.scriza.EventManagement.Exceptions;

public class EventAlreadyFoundException extends RuntimeException {

    public EventAlreadyFoundException(String message) {
        super(message);
    }
}