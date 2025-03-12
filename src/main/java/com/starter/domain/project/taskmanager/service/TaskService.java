package com.starter.domain.project.taskmanager.service;

import com.starter.domain.project.taskmanager.dtos.TaskRequestDto;
import com.starter.domain.project.taskmanager.modal.Task;
import com.starter.domain.project.taskmanager.modal.TaskStatus;

import java.util.List;

public interface TaskService {
    Task createTask(TaskRequestDto request);
    List<Task> getAllTasks();
    List<Task> getTasksByStatus(TaskStatus status);
    Task getTaskById(Long id);
    Task update(Long id, TaskRequestDto request);
    void delete(Long id);
}
