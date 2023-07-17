package com.example.controller;

import com.example.dto.LoginDTO;
import com.example.dto.ProfileDTO;
import com.example.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/verification/email/{jwt}")
    ResponseEntity<?> verification(@PathVariable("jwt") String jwt){
        String result=authService.verification(jwt);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        String response = authService.login(dto);
        return ResponseEntity.ok(response);
    }



     int game=3;

    public void game(){
        game=19;
    }
//this is a controller

}
