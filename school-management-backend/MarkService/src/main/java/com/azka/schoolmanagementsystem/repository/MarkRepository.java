package com.azka.schoolmanagementsystem.repository;

import com.azka.schoolmanagementsystem.entity.ClassEntity;
import com.azka.schoolmanagementsystem.entity.ExamEntity;
import com.azka.schoolmanagementsystem.entity.MarkEntity;
import com.azka.schoolmanagementsystem.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<MarkEntity, Long> {
    List<MarkEntity> findByExamAndClassEntityAndSubject(ExamEntity exam, ClassEntity classEntity, SubjectEntity subject);
}