package com.postgresql.assignment1.services;

import com.postgresql.assignment1.models.Person;
import com.postgresql.assignment1.models.Task;
import com.postgresql.assignment1.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo repo;

    public Task saveTask(Task task) {
        return repo.save(task);
    }

    public Task updateTask(Long id, Map<String, Object> fields) {
        Optional<Task> currentTask = repo.findById(id);

        if (currentTask.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Person.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, currentTask.get(), value);
            });

            return repo.save(currentTask.get());
        }
        return null;
    }
}
