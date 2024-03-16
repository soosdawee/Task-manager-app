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

import java.util.List;
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

    @PutMapping("/updatePerson/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @PatchMapping("/updatePerson/{id}")
    public Person updatePersonBetter(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return personService.updatePersonBetter(id, fields);
    }

    @PatchMapping("/updateTask/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/deletePerson/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/people")
    public List<Person> viewPeople() {
        return personService.getPeople();
    }

    @GetMapping("/tasks")
    public List<Task> viewTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }
}
