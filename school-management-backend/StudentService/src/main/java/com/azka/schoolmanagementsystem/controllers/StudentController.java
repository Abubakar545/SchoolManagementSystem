package com.azka.schoolmanagementsystem.controllers;

import com.azka.schoolmanagementsystem.entities.Student;
import com.azka.schoolmanagementsystem.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Management", description = "API for managing students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @Operation(summary = "Create a new student", description = "Adds a new student to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all students", description = "Retrieves a list of all students")
    @ApiResponse(responseCode = "200", description = "List of students", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class)))
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get specific Student", description = "Retrieves Student by id")
    @ApiResponse(responseCode = "200", description = "Gets Student By ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class)))
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> Student = studentService.getStudentById(id);
        return Student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a student", description = "Updates an existing student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Student not found", content = @Content)
    })
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a student", description = "Deletes an existing student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Student deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Student not found", content = @Content)
    })
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}