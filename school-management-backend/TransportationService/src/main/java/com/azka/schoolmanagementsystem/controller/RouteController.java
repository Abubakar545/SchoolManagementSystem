package com.azka.schoolmanagementsystem.controller;

import com.azka.schoolmanagementsystem.entity.Route;
import com.azka.schoolmanagementsystem.service.RouteService;
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
@RequestMapping("/api/transportation/routes")
public class RouteController {

    private final RouteService routeService;


    @PostMapping
    @Operation(summary = "Create a new route", description = "Adds a new route to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Route created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Route.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    public ResponseEntity<Route> saveRoute(@Valid @RequestBody Route route) {
        Route savedRoute = routeService.saveRoute(route);
        return new ResponseEntity<>(savedRoute, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a route", description = "Updates an existing route")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Route updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Route.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Route not found", content = @Content)
    })
    public ResponseEntity<Route> updateRoute(@PathVariable Long id, @Valid @RequestBody Route route) {
        Route updatedRoute = routeService.updateRoute(id, route);
        return ResponseEntity.ok(updatedRoute);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a route", description = "Deletes an existing route")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Route deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Route not found", content = @Content)
    })
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Get all routes", description = "Retrieves a list of all routes")
    @ApiResponse(responseCode = "200", description = "List of routes", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Route.class)))
    public ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routes = routeService.getAllRoutes();
        return ResponseEntity.ok(routes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get specific route", description = "Retrieves route by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gets route by ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Route.class))),
            @ApiResponse(responseCode = "404", description = "Route not found", content = @Content)
    })
    public ResponseEntity<Route> getRouteById(@PathVariable Long id) {
        Route route = routeService.getRouteById(id);
        return ResponseEntity.ok(route);
    }

    @GetMapping("/location/{location}")
    @Operation(summary = "Get routes by location", description = "Retrieves routes by their location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of routes", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Route.class))),
            @ApiResponse(responseCode = "404", description = "Routes not found", content = @Content)
    })
    public ResponseEntity<List<Route>> getRoutesByLocation(@PathVariable String location) {
        List<Route> routes = routeService.getRoutesByLocation(location);
        return ResponseEntity.ok(routes);
    }
}
