package com.example.exceptions;

/**
 * Author: Alisher Odilov
 * Date: 17.03.2023
 */
public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
