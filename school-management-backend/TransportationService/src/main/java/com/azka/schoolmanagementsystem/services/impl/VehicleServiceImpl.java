package com.azka.schoolmanagementsystem.services.impl;

import com.azka.schoolmanagementsystem.entities.Vehicle;
import com.azka.schoolmanagementsystem.respositories.VehicleRepository;
import com.azka.schoolmanagementsystem.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));

        existingVehicle.setVehicleIdentifier(vehicle.getVehicleIdentifier());
        existingVehicle.setRegistrationNumber(vehicle.getRegistrationNumber());

        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
    }

    @Override
    public Vehicle getVehicleByNumber(String vehicleNumber) {
        return vehicleRepository.findByRegistrationNumber(vehicleNumber)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with registration number: " + vehicleNumber));
    }

}