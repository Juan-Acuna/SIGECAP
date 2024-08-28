package maryjaneslastdance.sigecap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class ApiConfig implements WebMvcConfigurer {
	@Override
    public void configurePathMatch(@NonNull PathMatchConfigurer configurer) {
        configurer.setPatternParser(new PathPatternParser()); // Usar PathPatternParser para mejorar el rendimiento.
        configurer.addPathPrefix("/api/v1", 
            c -> c.getPackageName().startsWith("maryjaneslastdance.sigecap.controller.api")); // Añadir prefijo solo para los controladores de la API.
    }
}
