package com.azka.schoolmanagementsystem.service.impl;

import com.azka.schoolmanagementsystem.entity.GradeEntity;
import com.azka.schoolmanagementsystem.exception.ResourceNotFoundException;
import com.azka.schoolmanagementsystem.repository.GradeRepository;
import com.azka.schoolmanagementsystem.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;

    @Override
    public List<GradeEntity> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public GradeEntity getGradeById(Long id) {
        return gradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grade not found with id: " + id));
    }

    @Override
    public GradeEntity createGrade(GradeEntity grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public GradeEntity updateGrade(GradeEntity grade) {
        gradeRepository.findById(grade.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Grade not found with id: " + grade.getId()));
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Long id) {
        GradeEntity grade = gradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grade not found with id: " + id));
        gradeRepository.delete(grade);
    }
}