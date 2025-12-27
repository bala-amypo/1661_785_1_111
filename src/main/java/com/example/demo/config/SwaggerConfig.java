package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    // ✅ This is the ONLY OpenAPI bean
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
        @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title("Hostel Roommate Compatibility Matcher API").version("1.0"))
                .components(new Components().addSecuritySchemes("bearer-jwt",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }
                .servers(List.of(
                        new Server().url("https://9186.pro604cr.amypo.ai/")
                ));
    }

    // ✅ Method required by tests, but NOT a bean
    public OpenAPI api() {
        return customOpenAPI();
    }
}