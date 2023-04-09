package com.example.exceptions;

/**
 * Author: Alisher Odilov
 * Date: 27.03.2023
 */
public class LoginOrPasswordWrongException extends RuntimeException {
    public LoginOrPasswordWrongException(String message) {
        super(message);
    }
}
