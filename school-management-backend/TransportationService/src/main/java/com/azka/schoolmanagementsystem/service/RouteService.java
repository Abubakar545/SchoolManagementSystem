package com.azka.schoolmanagementsystem.service;

import com.azka.schoolmanagementsystem.entity.Route;

import java.util.List;

public interface RouteService {
    Route saveRoute(Route route);
    Route updateRoute(Long id, Route route);
    void deleteRoute(Long id);
    List<Route> getAllRoutes();
    Route getRouteById(Long id);
    List<Route> getRoutesByLocation(String location);
}