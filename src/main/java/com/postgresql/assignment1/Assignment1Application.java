package com.postgresql.assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:${user.dir}/.env")
public class Assignment1Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment1Application.class, args);
    }

}
