package com.chapter.backend.customannotations.validator;

import com.chapter.backend.customannotations.annotation.ValidateEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


public class EmailValidator implements ConstraintValidator<ValidateEmail, String> {

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return pattern.matcher(value).matches();
    }
}
