package com.pkf.cbs.starter.domain.project.taskmanager.service;

import com.pkf.cbs.starter.domain.project.taskmanager.dtos.TaskRequestDto;
import com.pkf.cbs.starter.domain.project.taskmanager.dtos.TaskResponseDto;
import com.pkf.cbs.starter.domain.project.taskmanager.modal.Task;

import java.util.List;

public interface TaskService {
    Task createTask(TaskRequestDto request);
    List<Task> getAllTasks();
    List<Task> getTasksByStatus(String status);
    Task getTaskById(Long id);
    Task update(Long id, TaskRequestDto request);
    void delete(Long id);
}
