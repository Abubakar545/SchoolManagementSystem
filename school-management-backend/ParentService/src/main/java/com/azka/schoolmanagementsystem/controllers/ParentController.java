package com.azka.schoolmanagementsystem.controllers;


import com.azka.schoolmanagementsystem.entities.Parent;
import com.azka.schoolmanagementsystem.services.ParentService;
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
import java.util.Optional;


@RestController
@RequestMapping("/api/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping
    @Operation(summary = "Create a new parent", description = "Adds a new parent to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Parent created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Parent.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    public ResponseEntity<Parent> saveParent(@RequestBody Parent parent) {
        Parent savedParent = parentService.saveParent(parent);
        return new ResponseEntity<>(savedParent, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all parents", description = "Retrieves a list of all parents")
    @ApiResponse(responseCode = "200", description = "List of parents", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Parent.class)))
    public ResponseEntity<List<Parent>> getAllParents() {
        List<Parent> parents = parentService.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get specific parent", description = "Retrieves parent by id")
    @ApiResponse(responseCode = "200", description = "Gets parent By ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Parent.class)))
    public ResponseEntity<Parent> getParentById(@PathVariable Long id) {
        Optional<Parent> parent = parentService.getParentById(id);
        return parent.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Parent", description = "Updates an existing Parent")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Parent updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Parent.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Parent not found", content = @Content)
    })
    public ResponseEntity<Parent> updateParent(@PathVariable Long id, @RequestBody Parent parent) {
        Parent updatedParent = parentService.updateParent(id, parent);
        return ResponseEntity.ok(updatedParent);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Parent", description = "Deletes an existing Parent")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Parent deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Parent not found", content = @Content)
    })
    public ResponseEntity<Void> deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
        return ResponseEntity.noContent().build();
    }
}