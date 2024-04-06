package com.postgresql.assignment1.mappers;

import com.postgresql.assignment1.dtos.TaskDto;
import com.postgresql.assignment1.models.Task;

public class TaskMapper {
    public static TaskDto mapToTaskDto(Task task){
        TaskDto taskDto = new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription()
        );
        return taskDto;
    }

    // Convert UserDto into User JPA Entity
    public static Task mapToTask(TaskDto taskDto){
        Task task = new Task(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getDescription()
        );
        return task;
    }
}
