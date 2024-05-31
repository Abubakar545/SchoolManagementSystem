package com.azka.schoolmanagementsystem.service.impl;

import com.azka.schoolmanagementsystem.entity.Hall;
import com.azka.schoolmanagementsystem.repositories.HallRepository;
import com.azka.schoolmanagementsystem.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallRepository hallRepository;

    @Override
    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    @Override
    public Hall getHallById(Long id) {
        return hallRepository.findById(id).orElse(null);
    }

    @Override
    public Hall createHall(Hall hall) {
        return hallRepository.save(hall);
    }

    @Override
    public Hall updateHall(Long id, Hall hallDetails) {
        Hall existingHall = hallRepository.findById(id).orElse(null);
        if (existingHall != null) {
            existingHall.setHallName(hallDetails.getHallName());
            existingHall.setHallNumericValue(hallDetails.getHallNumericValue());
            existingHall.setCapacity(hallDetails.getCapacity());
            existingHall.setDescription(hallDetails.getDescription());
            return hallRepository.save(existingHall);
        }
        return null;
    }

    @Override
    public void deleteHall(Long id) {
        hallRepository.deleteById(id);
    }
}