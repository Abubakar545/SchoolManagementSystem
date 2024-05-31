package com.azka.schoolmanagementsystem.service;

import com.azka.schoolmanagementsystem.entity.Driver;

import java.util.List;

public interface DriverService {
    Driver saveDriver(Driver driver);
    Driver updateDriver(Long id, Driver driver);
    void deleteDriver(Long id);
    List<Driver> getAllDrivers();
    Driver getDriverById(Long id);
    List<Driver> getDriversByLicenseType(String licenseType);
}