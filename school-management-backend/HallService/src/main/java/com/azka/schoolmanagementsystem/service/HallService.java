package com.azka.schoolmanagementsystem.service;

import com.azka.schoolmanagementsystem.entity.Hall;

import java.util.List;

public interface HallService {
    List<Hall> getAllHalls();
    Hall getHallById(Long id);
    Hall createHall(Hall hall);
    Hall updateHall(Long id, Hall hallDetails);
    void deleteHall(Long id);
}