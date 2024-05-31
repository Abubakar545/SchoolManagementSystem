// Hall Entity
package com.azka.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hall")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hall_name")
    private String hallName;

    @Column(name = "hall_numeric_value")
    private Integer hallNumericValue;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "description")
    private String description;
}