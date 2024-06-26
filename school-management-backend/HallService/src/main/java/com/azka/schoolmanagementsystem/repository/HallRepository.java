package com.azka.schoolmanagementsystem.repository;

import com.azka.schoolmanagementsystem.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
}