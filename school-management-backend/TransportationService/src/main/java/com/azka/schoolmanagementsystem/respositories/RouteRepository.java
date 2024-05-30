package com.azka.schoolmanagementsystem.respositories;

import com.azka.schoolmanagementsystem.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findByLocation(String location);
}