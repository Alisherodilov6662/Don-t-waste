package com.example.exceptions;

/**
 * Author: Alisher Odilov
 * Date: 03.04.2023
 */
public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(String message) {
        super(message);
    }
}
