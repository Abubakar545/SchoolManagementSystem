package com.azka.schoolmanagementsystem.services.impl;

import com.azka.schoolmanagementsystem.entities.Teacher;
import com.azka.schoolmanagementsystem.exceptions.ResourceNotFoundException;
import com.azka.schoolmanagementsystem.respositories.TeacherRepository;
import com.azka.schoolmanagementsystem.services.TeacherService;
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
public class TeacherServiceImpl implements TeacherService {

    private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Autowired
    private final TeacherRepository teacherRepository;


    @Override
    @Transactional
    public Teacher saveTeacher(Teacher teacher) {
        try {
            logger.info("Saving teacher: {}", teacher);
            return teacherRepository.save(teacher);
        } catch (ConstraintViolationException ex) {
            logger.error("Validation failed for teacher: {}", teacher);
            Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
            violations.forEach(violation -> logger.error("Validation error: {}", violation.getMessage()));
            throw ex;
        }
    }

    @Override
    public List<Teacher> getAllTeachers() {
        logger.info("Retrieving all teachers");
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        logger.info("Retrieving teacher with id: {}", id);
        return teacherRepository.findById(id);
    }

    @Override
    @Transactional
    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        logger.info("Updating teacher with id: {}", id);
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));

        existingTeacher.setFirstName(updatedTeacher.getFirstName());
        existingTeacher.setMiddleName(updatedTeacher.getMiddleName());
        existingTeacher.setLastName(updatedTeacher.getLastName());
        existingTeacher.setGender(updatedTeacher.getGender());
        existingTeacher.setDateOfBirth(updatedTeacher.getDateOfBirth());
        existingTeacher.setAddress(updatedTeacher.getAddress());
        existingTeacher.setCity(updatedTeacher.getCity());
        existingTeacher.setState(updatedTeacher.getState());
        existingTeacher.setClassName(updatedTeacher.getClassName());
        existingTeacher.setPhoneNumber(updatedTeacher.getPhoneNumber());
        existingTeacher.setEmail(updatedTeacher.getEmail());
        existingTeacher.setWorkingHour(updatedTeacher.getWorkingHour());
        existingTeacher.setPosition(updatedTeacher.getPosition());
        existingTeacher.setUsername(updatedTeacher.getUsername());
        existingTeacher.setPassword(updatedTeacher.getPassword());
        existingTeacher.setImageUrl(updatedTeacher.getImageUrl());
        existingTeacher.setSubmittedDocuments(updatedTeacher.getSubmittedDocuments());

        return teacherRepository.save(existingTeacher);
    }

    @Override
    @Transactional
    public void deleteTeacher(Long id) {
        logger.info("Deleting teacher with id: {}", id);
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
        teacherRepository.delete(existingTeacher);
    }
}