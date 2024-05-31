package com.azka.schoolmanagementsystem.service;

import com.azka.schoolmanagementsystem.entity.GeneralSettings;

public interface GeneralSettingsService {

  GeneralSettings saveGeneralSettings(GeneralSettings generalSettings);

  GeneralSettings getGeneralSettings();

  GeneralSettings updateGeneralSettings(Long id, GeneralSettings updatedGeneralSettings);

  void deleteGeneralSettings(Long id);
}