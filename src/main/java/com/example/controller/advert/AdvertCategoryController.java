package com.example.controller.advert;

import com.example.controller.service.AdvertCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Alisher Odilov
 * Date: 16.07.2023
 */
@AllArgsConstructor
@RestController
@RequestMapping("/advertCategory")
public class AdvertCategoryController {
    private AdvertCategoryService advertCategoryService;
}
