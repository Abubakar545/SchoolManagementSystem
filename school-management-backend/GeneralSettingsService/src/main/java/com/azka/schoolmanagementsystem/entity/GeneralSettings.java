package com.azka.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class GeneralSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String schoolName;
    private int startingYear;
    private String schoolAddress;
    private String officialPhoneNumber;
    private String country;
    private String email;
    private String schoolLogo;
    private String profileCoverImage;
    
    // Constructors, getters, and setters
}