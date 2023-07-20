package com.example.controller.advert;

import com.example.dto.advert.AdvertSectionGetDTO;
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
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
      Boolean result=advertSectionService.deleteById(id);
      return ResponseEntity.ok(result);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        AdvertSectionGetDTO result=advertSectionService.getById(id);
        return ResponseEntity.ok(result);
    }

}

