package com.azka.schoolmanagementsystem.controller;

import com.azka.schoolmanagementsystem.entity.NoticeEntity;
import com.azka.schoolmanagementsystem.service.NoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping
    @Operation(summary = "Get all notices", description = "Retrieves a list of all notices")
    @ApiResponse(responseCode = "200", description = "List of notices", content = @Content(mediaType = "application/json", schema = @Schema(implementation = NoticeEntity.class)))
    public List<NoticeEntity> getAllNotices() {
        return noticeService.getAllNotices();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get specific notice", description = "Retrieves notice by ID")
    @ApiResponse(responseCode = "200", description = "Gets notice by ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = NoticeEntity.class)))
    public ResponseEntity<NoticeEntity> getNoticeById(@PathVariable Long id) {
        NoticeEntity notice = noticeService.getNoticeById(id);
        return notice != null ? ResponseEntity.ok(notice) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Create a new notice", description = "Adds a new notice to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Notice created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = NoticeEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    public NoticeEntity createNotice(@RequestBody NoticeEntity noticeEntity) {
        return noticeService.createNotice(noticeEntity);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a notice", description = "Updates an existing notice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notice updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = NoticeEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Notice not found", content = @Content)
    })
    public ResponseEntity<NoticeEntity> updateNotice(@PathVariable Long id, @RequestBody NoticeEntity updatedNotice) {
        NoticeEntity notice = noticeService.updateNotice(id, updatedNotice);
        return notice != null ? ResponseEntity.ok(notice) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a notice", description = "Deletes an existing notice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Notice deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Notice not found", content = @Content)
    })
    public ResponseEntity<HttpStatus> deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}
