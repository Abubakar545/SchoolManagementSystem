package com.azka.schoolmanagementsystem.service.impl;

import com.azka.schoolmanagementsystem.entity.Attendance;
import com.azka.schoolmanagementsystem.entity.AttendanceRecord;
import com.azka.schoolmanagementsystem.entity.Student;
import com.azka.schoolmanagementsystem.repositories.AttendanceRepository;
import com.azka.schoolmanagementsystem.repositories.StudentRepository;
import com.schoolmanagementsystem.services.AttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    private final StudentRepository studentRepository;


    @Override
    public Attendance saveAttendance(Attendance attendance) {
        List<AttendanceRecord> attendanceRecords = attendance.getAttendanceRecords();
        if (attendanceRecords != null) {
            for (AttendanceRecord attendanceRecord : attendanceRecords) {
                Student student = attendanceRecord.getStudent();
                if (student != null && student.getId() == null) {
                    // Save the new Student object and update the attendanceRecord with the saved Student
                    Student savedStudent = studentRepository.save(student);
                    attendanceRecord.setStudent(savedStudent);
                }
                attendanceRecord.setAttendance(attendance);
            }
        }

        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    // Implement other service methods as per requirement
}