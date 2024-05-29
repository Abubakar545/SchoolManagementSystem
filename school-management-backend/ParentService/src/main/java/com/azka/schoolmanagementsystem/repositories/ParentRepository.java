package com.azka.schoolmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.azka.schoolmanagementsystem.entities.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {

}