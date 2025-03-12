package com.starter.domain.project.taskmanager.service;

import com.starter.domain.project.common.utils.EntityNotFoundException;
import com.starter.domain.project.taskmanager.dtos.TaskRequestDto;
import com.starter.domain.project.taskmanager.modal.Task;
import com.starter.domain.project.taskmanager.modal.TaskStatus;
import com.starter.domain.project.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService{

    final TaskRepository repository;

    @Override
    public Task createTask(TaskRequestDto request) {
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }

    @Override
    public Task getTaskById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Task not found"));
    }

    @Override
    public Task update(Long id, TaskRequestDto request) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Task task = getTaskById(id);
        repository.delete(task);
    }
}
