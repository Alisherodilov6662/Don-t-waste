package com.example.config;

import com.example.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
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
    private final AuthEntryPointJwt authEntryPointJwt;

    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/",
            "/v3/api-docs//**",
            "/swagger-ui/**",
            "/swagger-resources",
            "/swagger-resources/"
    };
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
        http
                .httpBasic().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeHttpRequests()//autharizationdan o`tsin dedik
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/api/attach/public/**").permitAll()
                .requestMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest()
                .authenticated()
                .and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        http
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPointJwt);
        return http.build();
    }

}
