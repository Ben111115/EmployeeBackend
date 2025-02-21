package com.getarrays.employeemanager.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Erlaube CORS für alle Endpunkte
        registry.addMapping("/**")
                .allowedOrigins("*") // Erlaube alle Ursprünge
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Erlaube diese Methoden
                .allowedHeaders("*") // Erlaube alle Header
                .allowCredentials(true); // Wenn du Cookies oder Authentifizierung verwendest
    }
}

