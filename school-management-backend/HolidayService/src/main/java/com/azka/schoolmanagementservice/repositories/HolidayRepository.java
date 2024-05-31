package com.azka.schoolmanagementservice.repositories;

import com.azka.schoolmanagementservice.entitie.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity, Long> {
}