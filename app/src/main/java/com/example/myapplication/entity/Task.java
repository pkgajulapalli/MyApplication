package com.example.myapplication.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

import lombok.Data;

@Data
@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description = "";
    private String category = "";
    private TaskStatus taskStatus = TaskStatus.NOT_COMPLETED;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime finishedAt;
    private LocalDateTime deadLine;
}
