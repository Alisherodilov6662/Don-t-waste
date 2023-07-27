package com.example.controller.advert;

import com.example.dto.advert.AdvertCategoryCreationDTO;
import com.example.enums.Language;
import com.example.service.AdvertCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Alisher Odilov
 * Date: 16.07.2023
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/advertCategory")
public class AdvertCategoryController {

    private final AdvertCategoryService advertCategoryService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AdvertCategoryCreationDTO dto,
                                    @RequestHeader(value = "Accept-Language") Language language) {
        log.info("create AdvertCategory by AdvertCategoryCreationDTO  -> ", dto);
        AdvertCategoryCreationDTO result = advertCategoryService.create(dto, language);
        return ResponseEntity.ok(result);
    }

}
