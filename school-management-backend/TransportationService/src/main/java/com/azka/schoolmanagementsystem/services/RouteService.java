package com.azka.schoolmanagementsystem.services;

import com.azka.schoolmanagementsystem.entities.Route;

import java.util.List;

public interface RouteService {
    Route saveRoute(Route route);
    Route updateRoute(Long id, Route route);
    void deleteRoute(Long id);
    List<Route> getAllRoutes();
    Route getRouteById(Long id);
    List<Route> getRoutesByLocation(String location);
}