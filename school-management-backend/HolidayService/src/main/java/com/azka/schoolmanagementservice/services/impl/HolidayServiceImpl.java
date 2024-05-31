package com.azka.schoolmanagementservice.services.impl;

import com.azka.schoolmanagementservice.entitie.HolidayEntity;
import com.azka.schoolmanagementservice.repositories.HolidayRepository;
import com.azka.schoolmanagementservice.services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    @Override
    public List<HolidayEntity> getAllHolidays() {
        return holidayRepository.findAll();
    }

    @Override
    public HolidayEntity getHolidayById(Long id) {
        return holidayRepository.findById(id).orElse(null);
    }

    @Override
    public HolidayEntity createHoliday(HolidayEntity holiday) {
        return holidayRepository.save(holiday);
    }

    @Override
    public HolidayEntity updateHoliday(Long id, HolidayEntity holidayDetails) {
        HolidayEntity existingHoliday = holidayRepository.findById(id).orElse(null);
        if (existingHoliday != null) {
            existingHoliday.setHolidayTitle(holidayDetails.getHolidayTitle());
            existingHoliday.setDescription(holidayDetails.getDescription());
            existingHoliday.setStartDate(holidayDetails.getStartDate());
            existingHoliday.setEndDate(holidayDetails.getEndDate());
            return holidayRepository.save(existingHoliday);
        }
        return null;
    }

    @Override
    public void deleteHoliday(Long id) {
        holidayRepository.deleteById(id);
    }
}