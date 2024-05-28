package com.azka.schoolmanagementsystem.respositories;

import com.azka.schoolmanagementsystem.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
