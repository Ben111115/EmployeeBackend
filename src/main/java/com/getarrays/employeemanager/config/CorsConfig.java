package com.getarrays.employeemanager.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Konfiguriere CORS für alle Endpoints
        registry.addMapping("/**")  // Für alle Endpoints
                .allowedOrigins("https://employeefrontend-8ysm.onrender.com")  // Erlaubt CORS von der Angular-App
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Erlaubt nur diese HTTP-Methoden
                .allowedHeaders("*")  // Erlaubt alle Header
                .allowCredentials(true);  // Erlaubt Cookies (falls benötigt)
    }
}

