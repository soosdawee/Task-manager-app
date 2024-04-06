package com.postgresql.assignment1.services;

import com.postgresql.assignment1.dtos.TaskDto;
import com.postgresql.assignment1.interfaces.ServiceInterface;
import com.postgresql.assignment1.mappers.TaskMapper;
import com.postgresql.assignment1.models.Task;
import com.postgresql.assignment1.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService implements ServiceInterface<TaskDto> {
    @Autowired
    private TaskRepo repo;

    /*public Task saveTask(Task task) {
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
    }*/

    @Override
    public TaskDto create(TaskDto taskDto) {
        Task task = TaskMapper.mapToTask(taskDto);
        Task savedUser = repo.save(task);
        TaskDto savedTaskDto = TaskMapper.mapToTaskDto(savedUser);
        return savedTaskDto;
    }

    @Override
    public TaskDto getById(Long id) {
        return TaskMapper.mapToTaskDto(repo.findById(id).get());
    }

    @Override
    public List<TaskDto> getAll() {
        return repo.findAll().stream()
                .map(TaskMapper::mapToTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto update(Long id, Map<String, Object> fields) {
        Optional<Task> currentTask = repo.findById(id);

        if (currentTask.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Task.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, currentTask.get(), value);
            });

            System.out.println("Itt te: " + currentTask.get().getTitle());
            repo.save(currentTask.get());
            return TaskMapper.mapToTaskDto(currentTask.get());
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
