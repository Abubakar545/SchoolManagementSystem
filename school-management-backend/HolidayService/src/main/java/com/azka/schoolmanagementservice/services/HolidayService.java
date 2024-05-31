package com.azka.schoolmanagementservice.services;


import com.azka.schoolmanagementservice.entitie.HolidayEntity;

import java.util.List;

public interface HolidayService {
    List<HolidayEntity> getAllHolidays();
    HolidayEntity getHolidayById(Long id);
    HolidayEntity createHoliday(HolidayEntity holiday);
    HolidayEntity updateHoliday(Long id, HolidayEntity holidayDetails);
    void deleteHoliday(Long id);
}