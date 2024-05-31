package com.azka.schoolmanagementsystem.services;

import com.azka.schoolmanagementsystem.entities.GeneralSettings;

public interface GeneralSettingsService {

  GeneralSettings saveGeneralSettings(GeneralSettings generalSettings);

  GeneralSettings getGeneralSettings();

  GeneralSettings updateGeneralSettings(Long id, GeneralSettings updatedGeneralSettings);

  void deleteGeneralSettings(Long id);
}