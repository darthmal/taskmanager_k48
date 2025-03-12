package com.pkf.cbs.starter.domain.project.taskmanager.controller;

import com.pkf.cbs.starter.domain.project.taskmanager.dtos.TaskRequestDto;
import com.pkf.cbs.starter.domain.project.taskmanager.dtos.TaskResponseDto;
import com.pkf.cbs.starter.domain.project.taskmanager.mapper.TaskMapper;
import com.pkf.cbs.starter.domain.project.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1.0/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PostMapping
    public ResponseEntity<TaskResponseDto> createSlipAvailabilityRequest(@RequestBody @Valid TaskRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskMapper.toDto(taskService.createTask(dto)));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TaskResponseDto>> getTasksByStatus(@PathVariable String status) {
        return ResponseEntity.ok(taskMapper.toDtoList(taskService.getTasksByStatus(status)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskMapper.toDto(taskService.getTaskById(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskResponseDto>> getAllSlipAvailabilityRequests() {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskMapper.toDtoList(taskService.getAllTasks()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Long id, @RequestBody TaskRequestDto request) {
        return ResponseEntity.ok(taskMapper.toDto(taskService.update(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}