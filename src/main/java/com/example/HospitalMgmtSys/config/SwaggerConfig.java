package com.example.HospitalMgmtSys.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("H+ Care Platform")
                        .description("""
                                This is the official REST API documentation for the HPlus Care Platform.
                                
                                **Environment:** Development / QA / Production  
                                **Version:** 1.0.0  
                                **Maintained by:** Keshav Garg
                                """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Keshav Garg")
                                .email("gargkeshav859@gmail.com")
                                .url("https://keshav-garg-portfolio.netlify.app"))
                        .license(new License()
                                .name("Proprietary License")
                                .url("https://keshav-garg-portfolio.netlify.app")));
//                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
//                .components(new Components()
//                        .addSecuritySchemes(securitySchemeName,
//                                new SecurityScheme()
//                                        .name(securitySchemeName)
//                                        .type(SecurityScheme.Type.HTTP)
//                                        .scheme("bearer")
//                                        .bearerFormat("JWT")));
    }
}
