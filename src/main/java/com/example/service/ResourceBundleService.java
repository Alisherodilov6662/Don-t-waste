package com.example.service;

import com.example.config.ResourceBoundleMessageConfig;
import lombok.AllArgsConstructor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Author: Alisher Odilov
 * Date: 22.07.2023
 */

@Service
@AllArgsConstructor
public class ResourceBundleService {

    private final ResourceBundleMessageSource resourceBundleMessageSource;

    public String getMessage(String code, String lang) {
        return resourceBundleMessageSource.getMessage(code, null, new Locale(lang));
    }


    public String getMessage(String code, String lang, Object ... arg) {
        return resourceBundleMessageSource.getMessage(code, null, new Locale(lang));
    } //todo qo`shimcha parametr qabul qilsa shuni shu methodni yozamiz
}
