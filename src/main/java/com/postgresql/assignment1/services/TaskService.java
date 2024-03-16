package com.postgresql.assignment1.services;

import com.postgresql.assignment1.models.Person;
import com.postgresql.assignment1.models.Task;
import com.postgresql.assignment1.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo repo;

    public Task saveTask(Task task) {
        return repo.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task currentTask = repo.findById(id).get();
        currentTask.setDescription(task.getDescription());
        return repo.save(currentTask);
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }

    public List<Task> getTasks() {
        return repo.findAll();
    }

    public Task getTask(Long id) {
        return repo.findById(id).get();
    }
}
