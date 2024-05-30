package com.azka.schoolmanagementsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Student name cannot be blank")
    private String studentName;

    @NotBlank(message = "Class name cannot be blank")
    private String className;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    private String description;

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    private Double amount;

    @NotBlank(message = "Status cannot be blank")
    private String status;

    @NotNull(message = "Date cannot be null")
    private LocalDateTime date;
}
