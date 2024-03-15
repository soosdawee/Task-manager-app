package com.postgresql.assignment1.controllers;

import com.postgresql.assignment1.models.Person;
import com.postgresql.assignment1.repos.PersonRepo;
import com.postgresql.assignment1.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    PersonRepo personRepo;
    TaskRepo taskRepo;

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person) {
        personRepo.save(person);
    }
}
