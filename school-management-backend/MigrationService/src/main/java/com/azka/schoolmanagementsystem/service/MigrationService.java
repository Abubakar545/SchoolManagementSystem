package com.azka.schoolmanagementsystem.service;


public interface MigrationService {
    void migrateStudents(Long currentClassId, Long nextClassId, Long examId, int passingMarks);
}