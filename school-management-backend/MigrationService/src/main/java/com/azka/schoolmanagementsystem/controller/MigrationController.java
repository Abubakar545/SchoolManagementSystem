package com.azka.schoolmanagementsystem.controller;

import com.azka.schoolmanagementsystem.service.MigrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/migration")
public class MigrationController {
    private final MigrationService migrationService;

    public MigrationController(MigrationService migrationService) {
        this.migrationService = migrationService;
    }

    @PostMapping
    @Operation(summary = "Migrate students to next class", description = "Migrates students from current class to next class based on exam results")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Students migrated successfully", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<String> migrateStudents(@RequestParam Long currentClassId,
                                                  @RequestParam Long nextClassId,
                                                  @RequestParam Long examId,
                                                  @RequestParam int passingMarks) {
        migrationService.migrateStudents(currentClassId, nextClassId, examId, passingMarks);
        return ResponseEntity.ok("Students migrated successfully");
    }
}
