package com.azka.schoolmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.azka.schoolmanagementsystem.entity.Parent;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

}