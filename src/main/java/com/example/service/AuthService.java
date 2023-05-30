package com.example.service;

import com.example.dto.ProfileDTO;
import com.example.entity.ProfileEntity;
import com.example.enums.Role;
import com.example.enums.Status;
import com.example.exceptions.EmailAlreadyExistException;
import com.example.repository.ProfileRepository;
import com.example.util.MD5Util;
import io.jsonwebtoken.JwtException;
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

    public String registration(ProfileDTO dto) {
        Optional<ProfileEntity> optional=profileRepository.findByEmail(dto.getEmail());
        if (optional.isPresent()){
            ProfileEntity entity= optional.get();
            if (entity.getStatus().equals(Status.NOT_ACTIVE)){
                profileRepository.delete(entity);
            }else{
                throw new EmailAlreadyExistException("email exist ! ");
            }
        }

        ProfileEntity entity=new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPassword(MD5Util.MD5(dto.getPassword()));
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setRole(Role.USER);
        entity.setStatus(Status.NOT_ACTIVE);
        entity.setCreatedDate(LocalDateTime.now());
        profileRepository.save(entity);
        dto.setId(entity.getId());

        ///mail sender with jwt key
        return "Link was sent";
    }

    public String verification(String jwt) {
        String email;
        try{



        }catch (JwtException e){

        }

return null;
    }
}
