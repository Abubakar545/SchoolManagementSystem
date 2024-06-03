package com.azka.schoolmanagementsystem.service;

import com.azka.schoolmanagementsystem.entity.MarkEntity;

import java.util.List;

public interface MarkService {
    List<MarkEntity> getAllMarksByExamClassAndSubject(Long examId, Long classId, Long subjectId);
    MarkEntity getMarkById(Long id);
    MarkEntity createMark(MarkEntity mark);
    MarkEntity updateMark(MarkEntity mark);
    void deleteMark(Long id);
}