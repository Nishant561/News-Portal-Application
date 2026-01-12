package com.nishant.newsportal.annotation;


import com.nishant.newsportal.validations.FieldsMatchingValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FieldsMatchingValidation.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)


public @interface FieldsMatching {

String message() default "Fields values don't match!";

String field();

String fieldMatch();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        FieldsMatching[] value();
    }

}
