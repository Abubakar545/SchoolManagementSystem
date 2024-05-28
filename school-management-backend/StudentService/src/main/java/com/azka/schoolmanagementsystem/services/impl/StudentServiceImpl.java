package com.azka.schoolmanagementsystem.services.impl;

import com.azka.schoolmanagementsystem.entities.Student;
import com.azka.schoolmanagementsystem.exceptions.ResourceNotFoundException;
import com.azka.schoolmanagementsystem.repositories.StudentRepository;
import com.azka.schoolmanagementsystem.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        existingStudent.setStandard(student.getStandard());
        existingStudent.setRollNumber(student.getRollNumber());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setMiddleName(student.getMiddleName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setGender(student.getGender());
        existingStudent.setDateOfBirth(student.getDateOfBirth());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setCity(student.getCity());
        existingStudent.setState(student.getState());
        existingStudent.setZipCode(student.getZipCode());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setUserName(student.getUserName());
        existingStudent.setPassword(student.getPassword());
        existingStudent.setImageUrl(student.getImageUrl());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentRepository.delete(existingStudent);
    }
}