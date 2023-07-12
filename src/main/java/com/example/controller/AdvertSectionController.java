package com.example.controller;

import com.example.dto.advert.AdvertSectionCreationDTO;
import com.example.service.AdvertSectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Alisher Odilov
 * Date: 21.06.2023
 */
@RestController
@AllArgsConstructor
@RequestMapping("/advertSection")
public class AdvertSectionController {

    private final AdvertSectionService advertSectionService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AdvertSectionCreationDTO dto){
        AdvertSectionCreationDTO result=advertSectionService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody AdvertSectionCreationDTO dto, @PathVariable("id") Integer id){
        AdvertSectionCreationDTO result=advertSectionService.update(dto,id);
    }

}

