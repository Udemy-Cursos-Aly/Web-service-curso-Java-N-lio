package com.udemynelio.course.exceptions.service;

public class DatabaseExeption extends RuntimeException{
    private String message;
    public DatabaseExeption(String message) {
        super(message);
        this.message = message;
    }
}
