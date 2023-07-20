package com.example.controller.advert;

import com.example.dto.advert.AdvertCategoryCreationDTO;
import com.example.service.AdvertCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Alisher Odilov
 * Date: 16.07.2023
 */
@AllArgsConstructor
@RestController
@RequestMapping("/advertCategory")
public class AdvertCategoryController {

    private final AdvertCategoryService advertCategoryService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AdvertCategoryCreationDTO dto){
        AdvertCategoryCreationDTO result=advertCategoryService.create(dto);
        return ResponseEntity.ok(result);
    }

}
