package com.pkf.cbs.starter.domain.project.taskmanager.dtos;

import com.pkf.cbs.starter.domain.project.common.MandatoryField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDto {
    @MandatoryField
    private String title;

    private String description;

    @MandatoryField
    private String status;
}
