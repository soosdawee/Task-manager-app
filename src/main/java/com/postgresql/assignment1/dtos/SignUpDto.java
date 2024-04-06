package com.postgresql.assignment1.dtos;

import com.postgresql.assignment1.enums.PersonRole;

public record SignUpDto (
        String login,
        String password,
        String email,
        PersonRole role) {
}
