package com.azka.schoolmanagementsystem.services.impl;

import com.azka.schoolmanagementsystem.entities.Student;
import com.azka.schoolmanagementsystem.exceptions.ResourceNotFoundException;
import com.azka.schoolmanagementsystem.repositories.StudentRepository;
import com.azka.schoolmanagementsystem.services.StudentService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        try {
            logger.info("Saving student: {}", student);
            return studentRepository.save(student);
        } catch (ConstraintViolationException ex) {
            logger.error("Validation failed for student: {}", student);
            Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
            violations.forEach(violation -> logger.error("Validation error: {}", violation.getMessage()));
            throw ex;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        logger.info("Retrieving all students");
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        logger.info("Retrieving student with id: {}", id);
        return studentRepository.findById(id);
    }

    @Override
    @Transactional
    public Student updateStudent(Long id, Student updatedStudent) {
        logger.info("Updating student with id: {}", id);
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        existingStudent.setStandard(updatedStudent.getStandard());
        existingStudent.setRollNumber(updatedStudent.getRollNumber());
        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setMiddleName(updatedStudent.getMiddleName());
        existingStudent.setLastName(updatedStudent.getLastName());
        existingStudent.setGender(updatedStudent.getGender());
        existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());
        existingStudent.setAddress(updatedStudent.getAddress());
        existingStudent.setCity(updatedStudent.getCity());
        existingStudent.setState(updatedStudent.getState());
        existingStudent.setZipCode(updatedStudent.getZipCode());
        existingStudent.setPhone(updatedStudent.getPhone());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setUserName(updatedStudent.getUserName());
        existingStudent.setPassword(updatedStudent.getPassword());
        existingStudent.setImageUrl(updatedStudent.getImageUrl());

        return studentRepository.save(existingStudent);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        logger.info("Deleting student with id: {}", id);
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentRepository.delete(existingStudent);
    }
}