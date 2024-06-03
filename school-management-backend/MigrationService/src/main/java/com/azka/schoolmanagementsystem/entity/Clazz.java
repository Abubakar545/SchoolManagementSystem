package com.azka.schoolmanagementsystem.entity;// Clazz.java
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "currentClass")
    private Set<Student> students;
    @OneToOne
    private Clazz nextClass;
}