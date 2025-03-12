package com.pkf.cbs.starter.domain.project.taskmanager.service;

import com.pkf.cbs.starter.domain.project.taskmanager.dtos.TaskRequestDto;
import com.pkf.cbs.starter.domain.project.taskmanager.dtos.TaskResponseDto;
import com.pkf.cbs.starter.domain.project.taskmanager.modal.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService{
    @Override
    public Task createTask(TaskRequestDto request) {
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return List.of();
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        return List.of();
    }

    @Override
    public Task getTaskById(Long id) {
        return null;
    }

    @Override
    public Task update(Long id, TaskRequestDto request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
