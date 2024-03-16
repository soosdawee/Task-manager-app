package com.postgresql.assignment1.controllers;

import com.postgresql.assignment1.models.Person;
import com.postgresql.assignment1.models.Task;
import com.postgresql.assignment1.repos.PersonRepo;
import com.postgresql.assignment1.repos.TaskRepo;
import com.postgresql.assignment1.services.PersonService;
import com.postgresql.assignment1.services.TaskService;
import jakarta.persistence.PersistenceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    PersonService personService;
    @Autowired
    TaskService taskService;

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @PostMapping("/addTask")
    public void addTask(@RequestBody Task task) {
        taskService.saveTask(task);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @PatchMapping("/{id}")
    public Person updatePersonBetter(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return personService.updatePersonBetter(id, fields);
    }

    @PatchMapping("/task/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return taskService.updateTask(id, fields);
    }
}
