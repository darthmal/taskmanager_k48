package com.domain.project.taskmanager.mapper;

import com.domain.project.taskmanager.dtos.TaskRequestDto;
import com.domain.project.taskmanager.dtos.TaskResponseDto;
import com.domain.project.taskmanager.modal.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {

    @Mapping(target = "createdAt", expression = "java(com.domain.project.common.utils.DateTimeUtils.now())")
    @Mapping(target = "updatedAt", expression = "java(com.domain.project.common.utils.DateTimeUtils.now())")
    public abstract Task toEntity(TaskRequestDto taskRequestDto);

    public abstract TaskResponseDto toDto(Task entity);

    public abstract List<TaskResponseDto> toDtoList(List<Task> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", expression = "java(com.domain.project.common.utils.DateTimeUtils.now())")
    @Mapping(target = "title", expression = ("java(source.getTitle() != null && !source.getTitle().isEmpty()  ? source.getTitle() : target.getTitle())"))
    @Mapping(target = "description", expression = ("java(source.getDescription() != null && !source.getDescription().isEmpty()  ? source.getDescription() : target.getDescription())"))
    public abstract Task update(Task source, @MappingTarget Task target);
}
