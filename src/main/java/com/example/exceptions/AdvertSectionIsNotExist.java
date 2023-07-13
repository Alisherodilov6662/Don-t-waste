package com.example.exceptions;

/**
 * Author: Alisher Odilov
 * Date: 12.07.2023
 */
public class AdvertSectionIsNotExist extends RuntimeException {
    public AdvertSectionIsNotExist(String message) {
        super(message);
    }
}
