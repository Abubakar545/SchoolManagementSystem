package com.azka.schoolmanagementsystem.service.impl;// MigrationServiceImpl.java
import com.azka.schoolmanagementsystem.entity.Clazz;
import com.azka.schoolmanagementsystem.entity.Exam;
import com.azka.schoolmanagementsystem.repository.ClazzRepository;
import com.azka.schoolmanagementsystem.repository.ExamRepository;
import com.azka.schoolmanagementsystem.repository.StudentRepository;
import com.azka.schoolmanagementsystem.service.MigrationService;
import org.springframework.stereotype.Service;

@Service
public class MigrationServiceImpl implements MigrationService {
    private final StudentRepository studentRepository;
    private final ClazzRepository clazzRepository;
    private final ExamRepository examRepository;

    public MigrationServiceImpl(StudentRepository studentRepository,
                                ClazzRepository clazzRepository,
                                ExamRepository examRepository) {
        this.studentRepository = studentRepository;
        this.clazzRepository = clazzRepository;
        this.examRepository = examRepository;
    }

    @Override
    public void migrateStudents(Long currentClassId, Long nextClassId, Long examId, int passingMarks) {
        Clazz currentClass = clazzRepository.findById(currentClassId)
                .orElseThrow(() -> new RuntimeException("Current class not found"));
        Clazz nextClass = clazzRepository.findById(nextClassId)
                .orElseThrow(() -> new RuntimeException("Next class not found"));
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        currentClass.setNextClass(nextClass); // Set the next class
        clazzRepository.save(currentClass); // Save the updated current class

        currentClass.getStudents().stream()
                .filter(student -> student.getExamResult(exam) >= passingMarks)
                .forEach(student -> {
                    student.setCurrentClass(nextClass);
                    studentRepository.save(student);
                });
    }
}