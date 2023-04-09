package com.example.service;

import com.example.dto.LoginDTO;
import com.example.dto.LoginResponseDTO;
import com.example.dto.ProfileDTO;
import com.example.entity.ProfileEntity;
import com.example.enums.ProfileRole;
import com.example.enums.Status;
import com.example.exceptions.EmailAlreadyExistException;
import com.example.exceptions.LoginOrPasswordWrongException;
import com.example.exceptions.StatusBlockException;
import com.example.repository.ProfileRepository;
import com.example.util.JwtTokenUtil;
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
    private final MailService mailService;

    public String registration(ProfileDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findByEmail(dto.getEmail());
        if (optional.isPresent()) {
            ProfileEntity entity = optional.get();
            if (entity.getStatus().equals(Status.NOT_ACTIVE)) {
                profileRepository.delete(entity);
            } else {
                throw new EmailAlreadyExistException("email exist ! ");
            }
        }

        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPassword(MD5Util.MD5(dto.getPassword()));
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setRole(ProfileRole.USER);
        entity.setStatus(Status.NOT_ACTIVE);
        entity.setCreatedDate(LocalDateTime.now());
        profileRepository.save(entity);
        dto.setId(entity.getId());

        Thread thread = new Thread() {
            @Override
            public synchronized void start() {
                StringBuilder sb = new StringBuilder();
                sb.append("Hi "+entity.getName()+",\n");
                sb.append(" Bu test message");
                sb.append("Click the link:  http://localhost:8081/auth/verification/email/");
                sb.append(JwtTokenUtil.encode(dto.getEmail(),dto.getRole()));
//                mailService.sendEmail(dto.getEmail(), "Complite Registration", sb.toString());
            }
        };
        thread.start();
        return "Link was sent to your email !!! ";
    }

    public String verification(String jwt) {
        String email;
        try {
            email = JwtTokenUtil.decodeEmail(jwt);

        } catch (JwtException e) {
            return "Verification failed";
        }

        Optional<ProfileEntity> optional = profileRepository.findByEmail(email);

        if (optional.isEmpty()) {
            return "Verification failed";
        }

        ProfileEntity entity = optional.get();

        if (!entity.getStatus().equals(Status.NOT_ACTIVE)) {
            return "Verification failed";
        }
        entity.setStatus(Status.ACTIVE);
        profileRepository.save(entity);
        return "Verification successfully done";
    }

    public LoginResponseDTO login(LoginDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if(optional.isEmpty()){
            throw new LoginOrPasswordWrongException("Email or Password is incorrect !!! ");
        }
        ProfileEntity entity=optional.get();
        if (entity.getStatus().equals(Status.BLOCKED)){
            throw new StatusBlockException("Status blocked !!! ");
        }
        LoginResponseDTO responseDTO=new LoginResponseDTO();
        responseDTO.setName(entity.getName());
        responseDTO.setSurname(entity.getSurname());
        responseDTO.setRole(entity.getRole());
        responseDTO.setToken(JwtTokenUtil.encode(entity.getEmail(), entity.getRole()));
        return responseDTO;
    }
}
