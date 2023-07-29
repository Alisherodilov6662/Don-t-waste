package com.example.config;

import com.example.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Author: Alisher Odilov
 * Date: 18.03.2023
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {


    private final CustomUserDetailsService customUserDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtFilter jwtFilter;

    @Bean
    AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()  //csrf ni o`chirib qo`ydik
                .cors();         //cors esa yoniq

        http.authorizeHttpRequests()//autharizationdan o`tsin dedik
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/api/attach/public/**").permitAll()
                .anyRequest()        // xar qanday request o`tsin dedik
                .authenticated()    //authenticated
                .and()              // va
                .httpBasic()      // httpBasic bo`lsin dedik //todo shu yerda farq qiladi
                .and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);//bu yerda oldin filter qil deyapti
        //yani qandaydir tooken berilgan bo`lsa headerdan shuni tekshiradigan class o`zgaruvchisi
        return http.build();
    }

}
