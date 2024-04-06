package com.postgresql.assignment1.controllers;

import com.postgresql.assignment1.dtos.TaskDto;
import com.postgresql.assignment1.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto task){
        TaskDto savedUser = taskService.create(task);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long id){
        TaskDto task = taskService.getById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks(){
        List<TaskDto> tasks = taskService.getAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public TaskDto updateTask(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        System.out.println("here");
        return taskService.update(id, fields);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return new ResponseEntity<>("Task successfully deleted!", HttpStatus.OK);
    }

}
