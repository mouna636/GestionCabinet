package com.projet.GestionCabinet.Entities;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("cabinet-images", registry);
    }

    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path CabinetUploadDir = Paths.get("./cabinet-images");
        String CabinetUploadPath = CabinetUploadDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/cabinet-images/**").addResourceLocations("file:/" + CabinetUploadPath + "/");
    }
}
