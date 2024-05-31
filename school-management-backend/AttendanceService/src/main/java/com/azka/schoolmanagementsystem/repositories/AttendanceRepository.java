package com.azka.schoolmanagementsystem.repositories;

import com.azka.schoolmanagementsystem.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
