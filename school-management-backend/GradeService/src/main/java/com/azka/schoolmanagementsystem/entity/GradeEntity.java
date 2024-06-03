package com.azka.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "grades")
@Data
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String gradeName;

    @Column(nullable = false)
    private Integer gradePoint;

    @Column(nullable = false)
    private Integer markFrom;

    @Column(nullable = false)
    private Integer markUpto;

    private String comment;

    // Constructors, getters, and setters
}