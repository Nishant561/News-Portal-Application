package com.nishant.newsportal.annotation;

import com.nishant.newsportal.validations.PasswordValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidation.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)


public @interface PasswordValidators {

    String message() default "Weak Password not allowed!";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};



}
