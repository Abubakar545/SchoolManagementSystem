package com.azka.schoolmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String routeName;
    private double routeFare;
    private String location;

    @OneToOne
    private Vehicle vehicle;

    @OneToOne
    private Driver driver;
}