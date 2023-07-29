package com.example.exceptions;

/**
 * Author: Alisher Odilov
 * Date: 29.07.2023
 */
public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(String message) {
        super(message);
    }
}
