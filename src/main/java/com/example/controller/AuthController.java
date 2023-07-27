package com.example.controller;

import com.example.dto.LoginDTO;
import com.example.dto.ProfileDTO;
import com.example.enums.Language;
import com.example.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Alisher Odilov
 * Date: 17.03.2023
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/controller")
public class AuthController {

    @Autowired
    private final AuthService authService;

    @PostMapping("/registration")
    ResponseEntity<?> registration(@RequestBody ProfileDTO dto,
                                   @RequestHeader(value = "Accept-Language") Language language){
        log.info("registration ProfileDto: {} ", dto);
        String result=authService.registration(dto, language);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/verification/email/{jwt}")
    ResponseEntity<?> verification(@PathVariable("jwt") String jwt){
        log.info("verification jwt: {}", jwt);
        String result=authService.verification(jwt);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        log.info("login LoginDTO: {}", dto);
        String response = authService.login(dto);
        return ResponseEntity.ok(response);
    }



     int game=3;

    public void game(){
        game=19;
    }
//this is a controller

}
