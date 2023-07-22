package com.example.controller.exceptionHandleController;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Author: Alisher Odilov
 * Date: 22.07.2023
 */
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({ObjectNotFoundException.class, /*StudentCreationException.class*/})
    public ResponseEntity<?> handle(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
