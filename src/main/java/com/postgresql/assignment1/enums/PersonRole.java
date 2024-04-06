package com.postgresql.assignment1.enums;

public enum PersonRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    PersonRole(String role) {
        this.role = role;
    }

    public String getValue() {
        return role;
    }
}
