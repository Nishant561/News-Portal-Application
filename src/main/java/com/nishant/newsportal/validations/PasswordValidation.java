package com.nishant.newsportal.validations;

import com.nishant.newsportal.annotation.PasswordValidators;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidation implements ConstraintValidator<PasswordValidators, String> {

    private String regex;

    @Override
    public void initialize(PasswordValidators constraintAnnotation) {
        regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value != null){
            return value.matches(regex);
        }
        return false;
    }
}
