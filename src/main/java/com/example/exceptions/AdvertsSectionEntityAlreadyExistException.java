package com.example.exceptions;

/**
 * Author: Alisher Odilov
 * Date: 11.07.2023
 */
public class AdvertsSectionEntityAlreadyExistException extends RuntimeException {

    public AdvertsSectionEntityAlreadyExistException(String message) {
        super(message);
    }
}
