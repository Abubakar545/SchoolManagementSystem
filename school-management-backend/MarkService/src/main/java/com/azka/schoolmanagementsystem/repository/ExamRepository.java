package com.azka.schoolmanagementsystem.repository;

import com.azka.schoolmanagementsystem.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Long> {
    // Additional custom query methods, if needed
}