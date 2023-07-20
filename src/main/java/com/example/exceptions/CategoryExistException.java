package com.example.exceptions;

/**
 * Author: Alisher Odilov
 * Date: 19.07.2023
 */
public class CategoryExistException extends RuntimeException {
    public CategoryExistException(String message) {
        super(message);
    }
}
