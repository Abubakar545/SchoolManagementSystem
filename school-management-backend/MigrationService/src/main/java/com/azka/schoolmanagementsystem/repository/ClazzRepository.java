package com.azka.schoolmanagementsystem.repository;

import com.azka.schoolmanagementsystem.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClazzRepository extends JpaRepository<Clazz, Long> {
}
