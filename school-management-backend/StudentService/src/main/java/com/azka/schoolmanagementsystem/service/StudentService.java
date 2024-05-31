package com.azka.schoolmanagementsystem.service;

import com.azka.schoolmanagementsystem.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);

    Optional<Student> getStudentById(Long id);

}
