package com.azka.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "exams")
@Data
public class ExamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String examName;

    // Add any additional fields as needed

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private Set<MarkEntity> marks;

    // Constructors, getters, and setters
}