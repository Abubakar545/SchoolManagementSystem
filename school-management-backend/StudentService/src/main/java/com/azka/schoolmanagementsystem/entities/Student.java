package com.azka.schoolmanagementsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Standard is required")
    @Column(nullable = false)
    private String standard;

    @NotBlank(message = "Roll Number is required")
    @Column(nullable = false, unique = true)
    private String rollNumber;

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

    @NotBlank(message = "Zip Code is required")
    @Pattern(regexp = "^\\d{5}(?:[-\\s]\\d{4})?$", message = "Invalid Zip Code format")
    @Column(nullable = false)
    private String zipCode;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format")
    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Username is required")
    @Column(nullable = false, unique = true)
    private String userName;

    @NotBlank(message = "Password is required")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Image URL is required")
    @Column(nullable = false)
    private String imageUrl;

}