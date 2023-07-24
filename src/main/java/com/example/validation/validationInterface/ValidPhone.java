package com.example.validation.validationInterface;

import com.example.validation.validationCass.ValidPhoneValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Author: Alisher Odilov
 * Date: 24.07.2023
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidPhoneValidation.class)
public @interface ValidPhone {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
