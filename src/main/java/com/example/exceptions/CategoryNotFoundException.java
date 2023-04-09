package com.example.exceptions;

/**
 * Author: Alisher Odilov
 * Date: 30.03.2023
 */
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
