package com.azka.schoolmanagementsystem.repository;

import com.azka.schoolmanagementsystem.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
    // Additional custom query methods, if needed
}