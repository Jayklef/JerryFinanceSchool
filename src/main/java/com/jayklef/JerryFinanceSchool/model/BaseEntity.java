package com.jayklef.JerryFinanceSchool.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    public LocalDateTime createdAt;
    public String createdBy;
    public LocalDateTime updatedAt;
}
