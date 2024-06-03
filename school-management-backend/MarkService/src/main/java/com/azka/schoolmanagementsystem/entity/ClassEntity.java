package com.azka.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "classes")
@Data
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String className;

    // Add any additional fields as needed

    @OneToMany(mappedBy = "classEntity", cascade = CascadeType.ALL)
    private Set<MarkEntity> marks;

    // Constructors, getters, and setters
}