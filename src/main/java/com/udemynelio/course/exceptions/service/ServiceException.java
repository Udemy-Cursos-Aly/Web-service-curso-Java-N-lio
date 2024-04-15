package com.udemynelio.course.exceptions.service;

public class ServiceException extends RuntimeException{
    private String message;
    private static final long serialVersionUID = 1L;
    public ServiceException(String message, Object id) {
        super(message + id);
        this.message = message;
    }
}
