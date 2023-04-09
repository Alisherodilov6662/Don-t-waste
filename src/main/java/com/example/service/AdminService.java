package com.example.service;

import com.example.entity.ProfileEntity;
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

    public Boolean blocking(Long id) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ProfileNotFoundException("profile not found");
        }
        ProfileEntity entity = optional.get();
        entity.setStatus(Status.BLOCKED);
        profileRepository.save(entity);
        return true;
    }

    public Boolean activeing(Long id) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ProfileNotFoundException("profile not found");
        }
        ProfileEntity entity = optional.get();
        entity.setStatus(Status.ACTIVE);
        profileRepository.save(entity);
        return true;
    }

    public Boolean deleteProfileById(Long id) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ProfileNotFoundException("profile not found");
        }
        profileRepository.deleteById(id);
        return true;
    }

    public Boolean doingSecondAdmin(Long id) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ProfileNotFoundException("profile not found");
        }
        ProfileEntity entity = optional.get();
        entity.setRole(ProfileRole.SECONDADMIN);
        profileRepository.save(entity);
        return true;
    }

    public Boolean doingUserFromAdmin(Long id) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ProfileNotFoundException("profile not found");
        }
        ProfileEntity entity = optional.get();
        if (entity.getRole().equals(ProfileRole.ADMIN)) {
            throw new SomethingWentWrongException("this user admin");
        }
        if (entity.getRole().equals(ProfileRole.USER)) {
            throw new SomethingWentWrongException("this user user role");
        }
        entity.setRole(ProfileRole.USER);
        profileRepository.save(entity);
        return true;
    }
}
