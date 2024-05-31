package com.schoolmanagementsystem.services;

import com.azka.schoolmanagementsystem.entities.Attendance;

import java.util.List;

public interface AttendanceService {
    Attendance saveAttendance(Attendance attendance);
    Attendance getAttendanceById(Long id);
    List<Attendance> getAllAttendances();
    // Other service methods as per requirement
}