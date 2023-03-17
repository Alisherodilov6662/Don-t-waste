package com.example.controller;

import com.example.dto.ProfileDTO;
import com.example.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Alisher Odilov
 * Date: 17.03.2023
 */
@RestController
@AllArgsConstructor
@RequestMapping("/controller")
public class AuthController {

    @Autowired
    private final AuthService authService;

    @PostMapping("/registration")
    ResponseEntity<?> registration(@RequestBody ProfileDTO dto){
        String result=authService.registration(dto);
        return ResponseEntity.ok(result);
    }

}
