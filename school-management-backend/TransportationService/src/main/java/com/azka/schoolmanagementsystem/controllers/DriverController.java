package com.azka.schoolmanagementsystem.controllers;

import com.azka.schoolmanagementsystem.entities.Driver;
import com.azka.schoolmanagementsystem.services.DriverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transportation/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    @Operation(summary = "Create a new driver")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Driver created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    public ResponseEntity<Driver> saveDriver(@Valid @RequestBody Driver driver) {
        Driver savedDriver = driverService.saveDriver(driver);
        return new ResponseEntity<>(savedDriver, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a driver")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Driver updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "404", description = "Driver not found")
    })
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @Valid @RequestBody Driver driver) {
        Driver updatedDriver = driverService.updateDriver(id, driver);
        return ResponseEntity.ok(updatedDriver);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a driver")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Driver deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Driver not found")
    })
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Get all drivers")
    @ApiResponse(responseCode = "200", description = "List of drivers")
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get driver by ID")
    @ApiResponse(responseCode = "200", description = "Driver retrieved successfully")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        Driver driver = driverService.getDriverById(id);
        return ResponseEntity.ok(driver);
    }

    @GetMapping("/license-type/{licenseType}")
    @Operation(summary = "Get drivers by license type")
    @ApiResponse(responseCode = "200", description = "List of drivers")
    public ResponseEntity<List<Driver>> getDriversByLicenseType(@PathVariable String licenseType) {
        List<Driver> drivers = driverService.getDriversByLicenseType(licenseType);
        return ResponseEntity.ok(drivers);
    }
}
