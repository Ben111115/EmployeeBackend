package com.getarrays.employeemanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Erlaubt alle Endpunkte
                        .allowedOrigins("https://employeefrontend-8ysm.onrender.com") // Dein Angular-Frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Erlaubte HTTP-Methoden
                        .allowedHeaders("*") // Erlaubt alle Header
                        .allowCredentials(true); // Falls du Cookies oder Authentifizierung brauchst
            }
        };
    }
}
