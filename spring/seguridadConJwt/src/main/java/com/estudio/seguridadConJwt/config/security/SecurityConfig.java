package com.estudio.seguridadConJwt.config.security;

import com.estudio.seguridadConJwt.controllers.PermissionController;
import com.estudio.seguridadConJwt.repositories.PermissionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final PermissionRepository permissionRepository;

    private final PermissionController permissionController;

    SecurityConfig(PermissionController permissionController, PermissionRepository permissionRepository) {
        this.permissionController = permissionController;
        this.permissionRepository = permissionRepository;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity                      
                .csrf(csrf ->csrf.disable())
                .httpBasic(http -> http.disable())
                .formLogin(form -> form.disable())
                .authorizeHttpRequests(path -> path
                    .requestMatchers("/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated()   
                )
                .sessionManagement(session ->session 
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .build();
    }


    
}
