package com.postgresql.assignment1.interfaces;
import com.postgresql.assignment1.validators.ContainsLettersNumbersSpecialCharsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContainsLettersNumbersSpecialCharsValidator.class)
@Documented
public @interface ContainsLettersNumbersSpecialChars {

    String message() default "Must contain letters, numbers, and special characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
