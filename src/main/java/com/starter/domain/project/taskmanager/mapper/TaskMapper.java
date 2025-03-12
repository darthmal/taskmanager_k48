package com.starter.domain.project.taskmanager.mapper;

import com.starter.domain.project.taskmanager.dtos.TaskRequestDto;
import com.starter.domain.project.taskmanager.dtos.TaskResponseDto;
import com.starter.domain.project.taskmanager.modal.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {

    @Mapping(target = "createdAt", expression = "java(com.starter.domain.project.common.utils.DateTimeUtils.now())")
    @Mapping(target = "updatedAt", expression = "java(com.starter.domain.project.common.utils.DateTimeUtils.now())")
    public abstract Task toEntity(TaskRequestDto taskRequestDto);

    public abstract TaskResponseDto toDto(Task entity);

    public abstract List<TaskResponseDto> toDtoList(List<Task> entities);
}
