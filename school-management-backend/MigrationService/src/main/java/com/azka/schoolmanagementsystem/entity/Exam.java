package com.azka.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int passingMarks;

}