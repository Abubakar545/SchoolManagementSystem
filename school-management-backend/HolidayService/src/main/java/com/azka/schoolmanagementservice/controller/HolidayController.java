package com.azka.schoolmanagementservice.controller;

import com.azka.schoolmanagementservice.entitie.HolidayEntity;
import com.azka.schoolmanagementservice.services.HolidayService;
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
@RequestMapping("/api/holidays")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @GetMapping
    @Operation(summary = "Get all holidays", description = "Retrieves a list of all holidays")
    @ApiResponse(responseCode = "200", description = "List of holidays", content = @Content(mediaType = "application/json", schema = @Schema(implementation = HolidayEntity.class)))
    public List<HolidayEntity> getAllHolidays() {
        return holidayService.getAllHolidays();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get holiday by ID", description = "Retrieves a holiday by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Holiday found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = HolidayEntity.class))),
            @ApiResponse(responseCode = "404", description = "Holiday not found", content = @Content)
    })
    public ResponseEntity<HolidayEntity> getHolidayById(@PathVariable Long id) {
        HolidayEntity holiday = holidayService.getHolidayById(id);
        return holiday != null ? ResponseEntity.ok(holiday) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Create a new holiday", description = "Adds a new holiday to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Holiday created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = HolidayEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    public ResponseEntity<HolidayEntity> createHoliday(@RequestBody HolidayEntity holiday) {
        HolidayEntity createdHoliday = holidayService.createHoliday(holiday);
        return new ResponseEntity<>(createdHoliday, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a holiday", description = "Updates an existing holiday")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Holiday updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = HolidayEntity.class))),
            @ApiResponse(responseCode = "404", description = "Holiday not found", content = @Content)
    })
    public ResponseEntity<HolidayEntity> updateHoliday(@PathVariable Long id, @RequestBody HolidayEntity holidayDetails) {
        HolidayEntity updatedHoliday = holidayService.updateHoliday(id, holidayDetails);
        return updatedHoliday != null ? ResponseEntity.ok(updatedHoliday) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a holiday", description = "Deletes an existing holiday")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Holiday deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Holiday not found", content = @Content)
    })
    public ResponseEntity<HttpStatus> deleteHoliday(@PathVariable Long id) {
        holidayService.deleteHoliday(id);
        return ResponseEntity.noContent().build();
    }
}
