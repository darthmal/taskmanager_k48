package com.pkf.cbs.starter.domain.project.taskmanager.repository;

import com.pkf.cbs.starter.domain.project.taskmanager.modal.Task;
import com.pkf.cbs.starter.domain.project.taskmanager.modal.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
