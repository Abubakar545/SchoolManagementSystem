package com.azka.schoolmanagementsystem.controller;

import com.azka.schoolmanagementsystem.entity.MarkEntity;
import com.azka.schoolmanagementsystem.service.MarkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
@RequiredArgsConstructor
@Tag(name = "Mark", description = "Mark API")
public class MarkController {
    private final MarkService markService;

    @GetMapping
    @Operation(summary = "Get all marks by exam, class, and subject", description = "Retrieves a list of all marks by exam ID, class ID, and subject ID")
    @ApiResponse(responseCode = "200", description = "List of marks", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MarkEntity.class)))
    public ResponseEntity<List<MarkEntity>> getAllMarksByExamClassAndSubject(
            @RequestParam Long examId,
            @RequestParam Long classId,
            @RequestParam Long subjectId
    ) {
        List<MarkEntity> marks = markService.getAllMarksByExamClassAndSubject(examId, classId, subjectId);
        return ResponseEntity.ok(marks);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a mark by id", description = "Retrieves a mark by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gets mark by ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MarkEntity.class))),
            @ApiResponse(responseCode = "404", description = "Mark not found", content = @Content)
    })
    public ResponseEntity<MarkEntity> getMarkById(@PathVariable Long id) {
        MarkEntity mark = markService.getMarkById(id);
        return mark != null ? ResponseEntity.ok(mark) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Create a new mark", description = "Adds a new mark to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mark created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MarkEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    public ResponseEntity<MarkEntity> createMark(@RequestBody MarkEntity mark) {
        MarkEntity createdMark = markService.createMark(mark);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMark);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a mark", description = "Updates an existing mark")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mark updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MarkEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Mark not found", content = @Content)
    })
    public ResponseEntity<MarkEntity> updateMark(@PathVariable Long id, @RequestBody MarkEntity mark) {
        mark.setId(id);
        MarkEntity updatedMark = markService.updateMark(mark);
        return updatedMark != null ? ResponseEntity.ok(updatedMark) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a mark", description = "Deletes an existing mark")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Mark deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Mark not found", content = @Content)
    })
    public ResponseEntity<Void> deleteMark(@PathVariable Long id) {
        markService.deleteMark(id);
        return ResponseEntity.noContent().build();
    }
}
