package com.example.service;

import com.example.entity.ProfileEntity;
import com.example.enums.Language;
import com.example.enums.ProfileRole;
import com.example.enums.Status;
import com.example.exceptions.ProfileNotFoundException;
import com.example.exceptions.SomethingWentWrongException;
import com.example.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author: Alisher Odilov
 * Date: 03.04.2023
 */
@Service
@AllArgsConstructor
public class AdminService {

    private final ProfileRepository profileRepository;
    private final ResourceBundleService resourceBundleService;

    public Boolean blocking(Long id, Language language) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ProfileNotFoundException(resourceBundleService.getMessage("item.not.found", language.name()));
        }
        ProfileEntity entity = optional.get();
        entity.setStatus(Status.BLOCKED);
        profileRepository.save(entity);
        return true;
    }

    public Boolean activeing(Long id, Language language) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ProfileNotFoundException(resourceBundleService.getMessage("item.not.found", language.name()));
        }
        ProfileEntity entity = optional.get();
        entity.setStatus(Status.ACTIVE);
        profileRepository.save(entity);
        return true;
    }

    public Boolean deleteProfileById(Long id, Language language) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ProfileNotFoundException(resourceBundleService.getMessage("item.not.found", language.name()));
        }
        profileRepository.deleteById(id);
        return true;
    }

    public Boolean doingSecondAdmin(Long id, Language language) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ProfileNotFoundException(resourceBundleService.getMessage("item.not.found", language.name()));
        }
        ProfileEntity entity = optional.get();
        entity.setRole(ProfileRole.SECONDADMIN);
        profileRepository.save(entity);
        return true;
    }

    public Boolean doingUserFromAdmin(Long id, Language language) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ProfileNotFoundException(resourceBundleService.getMessage("item.not.found", language.name()));
        }
        ProfileEntity entity = optional.get();
        if (entity.getRole().equals(ProfileRole.ADMIN)) {
            throw new SomethingWentWrongException(resourceBundleService.getMessage("this.user.admin", language.name()));
        }
        if (entity.getRole().equals(ProfileRole.USER)) {
            throw new SomethingWentWrongException(resourceBundleService.getMessage("this.user.user", language.name()));
        }
        entity.setRole(ProfileRole.USER);
        profileRepository.save(entity);
        return true;
    }

    public  Boolean such(){

    }
}
