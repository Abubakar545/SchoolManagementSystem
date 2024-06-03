package com.azka.schoolmanagementsystem.service.impl;

import com.azka.schoolmanagementsystem.entity.GeneralSettings;
import com.azka.schoolmanagementsystem.repository.GeneralSettingsRepository;
import com.azka.schoolmanagementsystem.service.GeneralSettingsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class GeneralSettingsServiceImpl implements GeneralSettingsService {

    private final GeneralSettingsRepository generalSettingsRepository;

    @Override
    public GeneralSettings saveGeneralSettings(GeneralSettings generalSettings) {
        return generalSettingsRepository.save(generalSettings);
    }

    @Override
    public GeneralSettings getGeneralSettings() {
        return generalSettingsRepository.findAll().stream().findFirst().orElse(null);
    }

    @Override
    public GeneralSettings updateGeneralSettings(Long id, GeneralSettings updatedGeneralSettings) {
        Optional<GeneralSettings> existingGeneralSettings = generalSettingsRepository.findById(id);
        if (existingGeneralSettings.isPresent()) {
            GeneralSettings settings = existingGeneralSettings.get();
            settings.setSchoolName(updatedGeneralSettings.getSchoolName());
            settings.setStartingYear(updatedGeneralSettings.getStartingYear());
            settings.setSchoolAddress(updatedGeneralSettings.getSchoolAddress());
            settings.setOfficialPhoneNumber(updatedGeneralSettings.getOfficialPhoneNumber());
            settings.setCountry(updatedGeneralSettings.getCountry());
            settings.setEmail(updatedGeneralSettings.getEmail());
            settings.setSchoolLogo(updatedGeneralSettings.getSchoolLogo());
            settings.setProfileCoverImage(updatedGeneralSettings.getProfileCoverImage());
            return generalSettingsRepository.save(settings);
        }
        return null;
    }

    @Override
    public void deleteGeneralSettings(Long id) {
        generalSettingsRepository.deleteById(id);
    }
}