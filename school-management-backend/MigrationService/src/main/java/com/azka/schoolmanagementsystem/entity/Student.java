package com.azka.schoolmanagementsystem.entity;// Student.java
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Clazz currentClass;
    public int getExamResult(Exam exam) {
        // Implement the logic to retrieve the student's exam result for the given exam
        // You may need to add additional fields or relationships to the Student class
        // or retrieve the result from a separate data source
        return 0; // Replace with the actual exam result
    }
}


