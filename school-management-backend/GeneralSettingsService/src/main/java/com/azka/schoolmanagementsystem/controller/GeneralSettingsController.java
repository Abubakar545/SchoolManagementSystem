package com.azka.schoolmanagementsystem.controller;

import com.azka.schoolmanagementsystem.entity.GeneralSettings;
import com.azka.schoolmanagementsystem.service.GeneralSettingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/general-settings")
public class GeneralSettingsController {

    @Autowired
    private GeneralSettingsService generalSettingsService;

    @PostMapping
    @Operation(summary = "Create new general settings", description = "Adds new general settings to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "General settings created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GeneralSettings.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    public ResponseEntity<GeneralSettings> saveGeneralSettings(@RequestBody GeneralSettings generalSettings) {
        GeneralSettings savedSettings = generalSettingsService.saveGeneralSettings(generalSettings);
        return new ResponseEntity<>(savedSettings, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get general settings", description = "Retrieves the general settings")
    @ApiResponse(responseCode = "200", description = "General settings retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GeneralSettings.class)))
    public ResponseEntity<GeneralSettings> getGeneralSettings() {
        GeneralSettings settings = generalSettingsService.getGeneralSettings();
        return ResponseEntity.ok(settings);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update general settings", description = "Updates existing general settings")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "General settings updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GeneralSettings.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "General settings not found", content = @Content)
    })
    public ResponseEntity<GeneralSettings> updateGeneralSettings(@PathVariable Long id, @RequestBody GeneralSettings updatedGeneralSettings) {
        GeneralSettings updatedSettings = generalSettingsService.updateGeneralSettings(id, updatedGeneralSettings);
        if (updatedSettings != null) {
            return ResponseEntity.ok(updatedSettings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete general settings", description = "Deletes existing general settings")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "General settings deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "General settings not found", content = @Content)
    })
    public ResponseEntity<Void> deleteGeneralSettings(@PathVariable Long id) {
        generalSettingsService.deleteGeneralSettings(id);
        return ResponseEntity.noContent().build();
    }
}
