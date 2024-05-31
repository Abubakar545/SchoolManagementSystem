package com.azka.schoolmanagementsystem.service.impl;

import com.azka.schoolmanagementsystem.entity.Driver;
import com.azka.schoolmanagementsystem.respositories.DriverRepository;
import com.azka.schoolmanagementsystem.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(Long id, Driver driver) {
        Driver existingDriver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));

        existingDriver.setName(driver.getName());
        existingDriver.setPhoneNumber(driver.getPhoneNumber());
        existingDriver.setLicenseType(driver.getLicenseType());

        return driverRepository.save(existingDriver);
    }

    @Override
    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver getDriverById(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
    }

    @Override
    public List<Driver> getDriversByLicenseType(String licenseType) {
        return driverRepository.findByLicenseType(licenseType);
    }
}