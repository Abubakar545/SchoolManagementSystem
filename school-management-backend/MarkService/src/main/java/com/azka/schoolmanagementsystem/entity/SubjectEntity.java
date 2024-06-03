package com.azka.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "subjects")
@Data
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String subjectName;

    // Add any additional fields as needed

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private Set<MarkEntity> marks;

    // Constructors, getters, and setters
}