package com.example.service;

import com.example.config.CustomUserDetail;
import com.example.entity.ProfileEntity;
import com.example.exceptions.EmailNotFoundException;
import com.example.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author: Alisher Odilov
 * Date: 29.07.2023
 */

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final ProfileRepository profileRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ProfileEntity> optional=profileRepository.findByEmail(username);
        if (optional.isEmpty()){
            throw new EmailNotFoundException("Bad Credentials");
        }
        return new CustomUserDetail(optional.get());
    }
}
