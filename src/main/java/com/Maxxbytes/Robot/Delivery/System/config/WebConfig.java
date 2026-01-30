package com.Maxxbytes.Robot.Delivery.System.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web configuration class for customizing Spring MVC settings.
 * This includes CORS mappings for APIs and view controllers for frontend routes.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

/**
 * Configure CORS to allow requests from any origin for development purposes.
 * In production, restrict origins to specific domains.
 */
}