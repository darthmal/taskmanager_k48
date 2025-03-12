package com.starter.domain.project.taskmanager.modal;

import com.starter.domain.project.common.MandatoryField;
import com.starter.domain.project.common.utils.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import jakarta.persistence.*;


@Getter
@Setter
@Entity
@FieldNameConstants
@Table(name = "tasks")
public class Task extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MandatoryField
    private String title;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @MandatoryField
    private TaskStatus status;

}