package com.pkf.cbs.starter.domain.project.taskmanager.mapper;

import com.pkf.cbs.starter.domain.project.taskmanager.dtos.TaskRequestDto;
import com.pkf.cbs.starter.domain.project.taskmanager.dtos.TaskResponseDto;
import com.pkf.cbs.starter.domain.project.taskmanager.modal.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {

    public abstract Task toEntity(TaskRequestDto taskRequestDto);

    public abstract TaskResponseDto toDto(Task entity);

    public abstract List<TaskResponseDto> toDtoList(List<Task> entities);
}
