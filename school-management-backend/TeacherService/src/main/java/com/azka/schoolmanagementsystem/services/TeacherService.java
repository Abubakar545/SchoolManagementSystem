package com.azka.schoolmanagementsystem.services;

import com.azka.schoolmanagementsystem.entities.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Teacher saveTeacher(Teacher teacher);

    List<Teacher> getAllTeachers();

    Teacher updateTeacher(Long id, Teacher student);

    void deleteTeacher(Long id);

    Optional<Teacher> getTeacherById(Long id);
}
