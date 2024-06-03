package com.azka.schoolmanagementsystem.controller;

import com.azka.schoolmanagementsystem.entity.GradeEntity;
import com.azka.schoolmanagementsystem.service.GradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@RequiredArgsConstructor
@Tag(name = "Grade", description = "Grade API")
public class GradeController {
    private final GradeService gradeService;

    @GetMapping
    @Operation(summary = "Get all grades", description = "Retrieves a list of all grades")
    @ApiResponse(responseCode = "200", description = "List of grades", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GradeEntity.class)))
    public ResponseEntity<List<GradeEntity>> getAllGrades() {
        List<GradeEntity> grades = gradeService.getAllGrades();
        return ResponseEntity.ok(grades);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get specific grade", description = "Retrieves grade by ID")
    @ApiResponse(responseCode = "200", description = "Gets grade by ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GradeEntity.class)))
    public ResponseEntity<GradeEntity> getGradeById(@PathVariable Long id) {
        GradeEntity grade = gradeService.getGradeById(id);
        return grade != null ? ResponseEntity.ok(grade) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Create a new grade", description = "Adds a new grade to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Grade created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GradeEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    public ResponseEntity<GradeEntity> createGrade(@RequestBody GradeEntity grade) {
        GradeEntity createdGrade = gradeService.createGrade(grade);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGrade);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a grade", description = "Updates an existing grade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Grade updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GradeEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Grade not found", content = @Content)
    })
    public ResponseEntity<GradeEntity> updateGrade(@PathVariable Long id, @RequestBody GradeEntity grade) {
        grade.setId(id);
        GradeEntity updatedGrade = gradeService.updateGrade(grade);
        return updatedGrade != null ? ResponseEntity.ok(updatedGrade) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a grade", description = "Deletes an existing grade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Grade deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Grade not found", content = @Content)
    })
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }
}
