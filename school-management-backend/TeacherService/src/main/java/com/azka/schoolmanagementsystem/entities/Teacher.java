package com.azka.schoolmanagementsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name is required")
    @Column(nullable = false)
    private String firstName;

    @Column
    private String middleName;

    @NotBlank(message = "Last Name is required")
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "Gender is required")
    @Column(nullable = false)
    private String gender;

    @NotNull(message = "Date of Birth is required")
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @NotBlank(message = "Address is required")
    @Column(nullable = false)
    private String address;

    @NotBlank(message = "City is required")
    @Column(nullable = false)
    private String city;

    @NotBlank(message = "State is required")
    @Column(nullable = false)
    private String state;

    @NotBlank(message = "Class Name is required")
    @Column(nullable = false)
    private String className;

    @NotBlank(message = "Phone Number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format")
    @Column(nullable = false)
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String workingHour;

    @NotBlank(message = "Position is required")
    @Column(nullable = false)
    private String position;

    @NotBlank(message = "Username is required")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Password is required")
    @Column(nullable = false)
    private String password;

    @Column
    private String imageUrl;

    @ElementCollection
    @CollectionTable(name = "teacher_documents", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "document")
    private List<String> submittedDocuments;

}