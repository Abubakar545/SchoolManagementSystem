package com.azka.schoolmanagementsystem.service;

import com.azka.schoolmanagementsystem.entity.GradeEntity;

import java.util.List;

public interface GradeService {
    List<GradeEntity> getAllGrades();
    GradeEntity getGradeById(Long id);
    GradeEntity createGrade(GradeEntity grade);
    GradeEntity updateGrade(GradeEntity grade);
    void deleteGrade(Long id);
}