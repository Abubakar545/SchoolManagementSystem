package com.azka.schoolmanagementsystem.repository;

import com.azka.schoolmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
