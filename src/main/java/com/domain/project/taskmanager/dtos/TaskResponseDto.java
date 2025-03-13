package com.domain.project.taskmanager.dtos;

import com.domain.project.common.basestructure.dto.BaseResponseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto extends BaseResponseDto {

    private Long id;
    private String title;
    private String description;
    private String status;
}
