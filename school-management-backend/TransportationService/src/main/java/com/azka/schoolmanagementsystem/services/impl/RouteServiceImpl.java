package com.azka.schoolmanagementsystem.services.impl;

import com.azka.schoolmanagementsystem.entities.Route;
import com.azka.schoolmanagementsystem.respositories.RouteRepository;
import com.azka.schoolmanagementsystem.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route updateRoute(Long id, Route route) {
        Route existingRoute = routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + id));

        existingRoute.setRouteName(route.getRouteName());
        existingRoute.setRouteFare(route.getRouteFare());
        existingRoute.setLocation(route.getLocation());
        existingRoute.setVehicle(route.getVehicle());
        existingRoute.setDriver(route.getDriver());

        return routeRepository.save(existingRoute);
    }

    @Override
    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Route getRouteById(Long id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + id));
    }

    @Override
    public List<Route> getRoutesByLocation(String location) {
        return routeRepository.findByLocation(location);
    }
}