package com.postgresql.assignment1.validators;

import com.postgresql.assignment1.interfaces.ContainsLettersNumbersSpecialChars;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContainsLettersNumbersSpecialCharsValidator implements ConstraintValidator<ContainsLettersNumbersSpecialChars, String> {

    @Override
    public void initialize(ContainsLettersNumbersSpecialChars constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch : value.toCharArray()) {
            if (Character.isLetter(ch)) {
                hasLetter = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }

            if (hasLetter && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }
}
