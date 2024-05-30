package com.azka.schoolmanagementsystem.controllers;

import com.azka.schoolmanagementsystem.entities.Vehicle;
import com.azka.schoolmanagementsystem.services.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/transportation/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    @Operation(summary = "Create a new vehicle", description = "Adds a new vehicle to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vehicle created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vehicle.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    public ResponseEntity<Vehicle> saveVehicle(@Valid @RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a vehicle", description = "Updates an existing vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehicle updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vehicle.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Vehicle not found", content = @Content)
    })
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @Valid @RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicle);
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a vehicle", description = "Deletes an existing vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Vehicle deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Vehicle not found", content = @Content)
    })
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Get all vehicles", description = "Retrieves a list of all vehicles")
    @ApiResponse(responseCode = "200", description = "List of vehicles", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vehicle.class)))
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get specific vehicle", description = "Retrieves vehicle by id")
    @ApiResponse(responseCode = "200", description = "Gets vehicle by ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vehicle.class)))
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("/number/{vehicleNumber}")
    @Operation(summary = "Get vehicle by number", description = "Retrieves vehicle by its registration number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehicle retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vehicle.class))),
            @ApiResponse(responseCode = "404", description = "Vehicle not found", content = @Content)
    })
    public ResponseEntity<Vehicle> getVehicleByNumber(@PathVariable String vehicleNumber) {
        Vehicle vehicle = vehicleService.getVehicleByNumber(vehicleNumber);
        return ResponseEntity.ok(vehicle);
    }


}
