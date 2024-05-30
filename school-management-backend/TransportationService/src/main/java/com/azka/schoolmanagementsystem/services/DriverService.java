package com.azka.schoolmanagementsystem.services;

import com.azka.schoolmanagementsystem.entities.Driver;

import java.util.List;

public interface DriverService {
    Driver saveDriver(Driver driver);
    Driver updateDriver(Long id, Driver driver);
    void deleteDriver(Long id);
    List<Driver> getAllDrivers();
    Driver getDriverById(Long id);
    List<Driver> getDriversByLicenseType(String licenseType);
}