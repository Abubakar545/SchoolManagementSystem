package com.azka.schoolmanagementsystem.service.impl;

import com.azka.schoolmanagementsystem.entity.*;
import com.azka.schoolmanagementsystem.exception.ResourceNotFoundException;
import com.azka.schoolmanagementsystem.repository.*;
import com.azka.schoolmanagementsystem.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {
    private final MarkRepository markRepository;
    private final ExamRepository examRepository;
    private final ClassRepository classRepository;
    private final SubjectRepository subjectRepository;

    @Override
    public List<MarkEntity> getAllMarksByExamClassAndSubject(Long examId, Long classId, Long subjectId) {
        ExamEntity exam = examRepository.findById(examId)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found with id: " + examId));
        ClassEntity classEntity = classRepository.findById(classId)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found with id: " + classId));
        SubjectEntity subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + subjectId));
        return markRepository.findByExamAndClassEntityAndSubject(exam, classEntity, subject);
    }

    @Override
    public MarkEntity getMarkById(Long id) {
        return markRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mark not found with id: " + id));
    }

    @Override
    public MarkEntity createMark(MarkEntity mark) {
        return markRepository.save(mark);
    }

    @Override
    public MarkEntity updateMark(MarkEntity mark) {
        markRepository.findById(mark.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Mark not found with id: " + mark.getId()));
        return markRepository.save(mark);
    }

    @Override
    public void deleteMark(Long id) {
        MarkEntity mark = markRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mark not found with id: " + id));
        markRepository.delete(mark);
    }
}