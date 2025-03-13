package com.domain.project.taskmanager.service;

import com.domain.project.common.utils.EntityNotFoundException;
import com.domain.project.core.exception.UniqueConstraintViolationException;
import com.domain.project.taskmanager.dtos.TaskRequestDto;
import com.domain.project.taskmanager.mapper.TaskMapper;
import com.domain.project.taskmanager.modal.Task;
import com.domain.project.taskmanager.modal.TaskStatus;
import com.domain.project.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService{

    private final TaskRepository repository;
    private final TaskMapper taskMapper;

    @Override
    public Task createTask(TaskRequestDto request) {
        checkUniqueTitle(request);
        Task task = taskMapper.toEntity(request);
        return repository.save(task);
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
        checkUniqueTitle(request);
        Task target = getTaskById(id);
        Task source = taskMapper.toEntity(request);
        return repository.save(taskMapper.update(source, target));
    }

    @Override
    public void delete(Long id) {
        Task task = getTaskById(id);
        repository.delete(task);
    }

    private void checkUniqueTitle(TaskRequestDto dto) {
        if (repository.countAllByTitle(dto.getTitle()) > 0) throw new UniqueConstraintViolationException("Field must be unique", "Title");
    }
}
