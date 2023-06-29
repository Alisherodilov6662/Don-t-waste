package com.example.controller;

import com.example.dto.advert.AdvertSectionCreationDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Alisher Odilov
 * Date: 21.06.2023
 */
@RestController
@AllArgsConstructor
@RequestMapping("/advertSection")
public class AdvertSectionController {

    @PostMapping("/create")
    public ResponseEntity<> create(@RequestBody AdvertSectionCreationDTO dto){

    }

}

