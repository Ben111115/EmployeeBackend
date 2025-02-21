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
        registry.addMapping("/**")  // Alle Endpoints
                .allowedOrigins("https://employeefrontend-8ysm.onrender.com", "http://localhost:4200") // Frontend URLs
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Erlaubte Methoden
                .allowedHeaders("*")  // Erlaubt alle Header
                .allowCredentials(true);  // Falls Cookies erforderlich sind
    }
}

