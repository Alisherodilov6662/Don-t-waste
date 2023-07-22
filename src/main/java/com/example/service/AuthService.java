package com.example.service;

import com.example.dto.LoginDTO;
import com.example.dto.ProfileDTO;
import com.example.entity.ProfileEntity;
import com.example.enums.Language;
import com.example.enums.ProfileRole;
import com.example.enums.Status;
import com.example.exceptions.EmailAlreadyExistException;
import com.example.repository.ProfileRepository;
import com.example.util.MD5Util;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Author: Alisher Odilov
 * Date: 17.03.2023
 */
@Service
@AllArgsConstructor
public class AuthService {
    private final ProfileRepository profileRepository;

    private final ResourceBundleService resourceBundleService;


    public String registration(ProfileDTO dto, Language language) {
        Optional<ProfileEntity> optional=profileRepository.findByEmail(dto.getEmail());
        if (optional.isPresent()){
            ProfileEntity entity= optional.get();
            if (entity.getStatus().equals(Status.NOT_ACTIVE)){
                profileRepository.delete(entity);
            }else{
                throw new EmailAlreadyExistException(resourceBundleService.getMessage("email.exist", language.name()));
            }
        }

        ProfileEntity entity=new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPassword(MD5Util.MD5(dto.getPassword()));
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setRole(ProfileRole.USER);
        entity.setStatus(Status.NOT_ACTIVE);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setAttach_id(dto.getAttach_id());

        profileRepository.save(entity);
        dto.setId(entity.getId());

        ///mail sender with jwt key
        return "Link was sent";
    }



    public String verification(String jwt) {
        String email;

//verification codes
    }

    public String login(LoginDTO dto) {
        Optional<ProfileEntity> optional=profileRepository.findByEmail(dto.getEmail());

        if (optional.isEmpty()){
            return "Email is not exist ! ";
        }
        ProfileEntity entity=optional.get();
        if (entity.getStatus().equals(Status.BLOCKED)||entity.getStatus().equals(Status.NOT_ACTIVE)){
            return "User was blocked or Non-Active";
        }
        if (!MD5Util.MD5(dto.getPassword()).equals(entity.getPassword())){
            return "password is incorrect!";
        }
        return "succesfully login";
    }
}
