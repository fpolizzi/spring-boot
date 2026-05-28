package com.fpolizzi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Created by fpolizzi on 5/28/26
 */
public class FooValidator implements
        ConstraintValidator<Foo, String> {
    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext context) {

        return value == null || value.equalsIgnoreCase("Foo");
    }
}
