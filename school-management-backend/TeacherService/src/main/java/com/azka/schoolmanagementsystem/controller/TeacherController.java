package com.azka.schoolmanagementsystem.controller;

import com.azka.schoolmanagementsystem.entity.Teacher;
import com.azka.schoolmanagementsystem.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    @Operation(summary = "Create a new teacher", description = "Adds a new teacher to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Teacher created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    public ResponseEntity<Teacher> saveTeacher(@Valid @RequestBody Teacher teacher, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Teacher savedTeacher = teacherService.saveTeacher(teacher);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all teachers", description = "Retrieves a list of all teachers")
    @ApiResponse(responseCode = "200", description = "List of teachers", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class)))
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get specific teacher", description = "Retrieves teacher by id")
    @ApiResponse(responseCode = "200", description = "Gets teacher By ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class)))
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Teacher", description = "Updates an existing Teacher")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Teacher updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Teacher not found", content = @Content)
    })
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @Valid @RequestBody Teacher teacher, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
        return ResponseEntity.ok(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Teacher", description = "Deletes an existing Teacher")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Teacher deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Teacher not found", content = @Content)
    })
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}