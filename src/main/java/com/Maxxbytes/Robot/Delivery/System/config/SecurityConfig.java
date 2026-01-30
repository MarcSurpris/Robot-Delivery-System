package com.Maxxbytes.Robot.Delivery.System.config;

import com.Maxxbytes.Robot.Delivery.System.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class for setting up authentication and authorization.
 * Uses basic HTTP authentication with role-based access control.
 */
@Configuration
public class SecurityConfig {

}