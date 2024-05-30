package com.azka.schoolmanagementsystem.services;

import com.azka.schoolmanagementsystem.entities.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle saveVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    void deleteVehicle(Long id);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Long id);
    Vehicle getVehicleByNumber(String vehicleNumber);
}