package com.azka.schoolmanagementsystem.controller;

import com.azka.schoolmanagementsystem.entity.Hall;
import com.azka.schoolmanagementsystem.service.HallService;
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
@RequestMapping("/api/halls")
public class HallController {

    @Autowired
    private HallService hallService;

    @GetMapping
    @Operation(summary = "Get all halls", description = "Retrieves a list of all halls")
    @ApiResponse(responseCode = "200", description = "List of halls", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hall.class)))
    public List<Hall> getAllHalls() {
        return hallService.getAllHalls();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get specific hall", description = "Retrieves hall by ID")
    @ApiResponse(responseCode = "200", description = "Gets hall by ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hall.class)))
    public ResponseEntity<Hall> getHallById(@PathVariable Long id) {
        Hall hall = hallService.getHallById(id);
        return hall != null ? ResponseEntity.ok(hall) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Create a new hall", description = "Adds a new hall to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Hall created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hall.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    public Hall createHall(@RequestBody Hall hall) {
        return hallService.createHall(hall);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a hall", description = "Updates an existing hall")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hall updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hall.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Hall not found", content = @Content)
    })
    public ResponseEntity<Hall> updateHall(@PathVariable Long id, @RequestBody Hall hallDetails) {
        Hall updatedHall = hallService.updateHall(id, hallDetails);
        return updatedHall != null ? ResponseEntity.ok(updatedHall) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a hall", description = "Deletes an existing hall")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Hall deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Hall not found", content = @Content)
    })
    public ResponseEntity<HttpStatus> deleteHall(@PathVariable Long id) {
        hallService.deleteHall(id);
        return ResponseEntity.noContent().build();
    }
}
