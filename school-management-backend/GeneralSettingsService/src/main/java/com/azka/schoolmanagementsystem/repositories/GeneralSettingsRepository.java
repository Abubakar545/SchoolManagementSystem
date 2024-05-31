package com.azka.schoolmanagementsystem.repositories;

import com.azka.schoolmanagementsystem.entities.GeneralSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralSettingsRepository extends JpaRepository<GeneralSettings, Long> {

}