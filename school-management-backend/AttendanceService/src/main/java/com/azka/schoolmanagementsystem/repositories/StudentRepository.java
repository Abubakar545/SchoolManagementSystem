package com.azka.schoolmanagementsystem.repositories;

import com.azka.schoolmanagementsystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
