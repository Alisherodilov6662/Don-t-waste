package com.example.validation.validationCass;

import com.example.validation.validationInterface.ValidPhone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Alisher Odilov
 * Date: 24.07.2023
 */
public class ValidPhoneValidation implements ConstraintValidator<ValidPhone, String> {

    private final String PHONE_PATTERN="(?:\\+[0-9]{12})";
    private final Pattern PATTERN=Pattern.compile(PHONE_PATTERN);


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value==null) return false;
        Matcher matcher=PATTERN.matcher(value);
        return matcher.matches();
    }
}
