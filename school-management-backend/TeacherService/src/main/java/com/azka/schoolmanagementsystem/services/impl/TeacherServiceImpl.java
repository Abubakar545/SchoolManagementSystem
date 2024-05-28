package com.azka.schoolmanagementsystem.services.impl;

import com.azka.schoolmanagementsystem.entities.Teacher;
import com.azka.schoolmanagementsystem.exceptions.ResourceNotFoundException;
import com.azka.schoolmanagementsystem.respositories.TeacherRepository;
import com.azka.schoolmanagementsystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
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

    public void deleteTeacher(Long id) {
        Teacher existingStudent = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        teacherRepository.delete(existingStudent);
    }

}
