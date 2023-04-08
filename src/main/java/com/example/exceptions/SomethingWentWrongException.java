package com.example.exceptions;

/**
 * Author: Alisher Odilov
 * Date: 03.04.2023
 */
public class SomethingWentWrongException extends RuntimeException {

    public SomethingWentWrongException(String message) {
        super(message);
    }
}
