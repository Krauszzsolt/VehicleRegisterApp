package org.example.app.exceptions;

public class VehicelNotValidException extends RuntimeException{
    public VehicelNotValidException(String errorMessage) {
        super(errorMessage);
    }
}
