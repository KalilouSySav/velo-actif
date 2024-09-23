package com.example.tpfinsessiongestionvelo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springdoc.webmvc.ui.SwaggerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Documentation API pour un service web RESTful (SAAS) de Velo Actif")
                        .version("v1.0")
                        .description("API de gestion de location de vélos, permettant des opérations telles que le remplissage des stocks et la gestion des prix.")

                );
    }

    @Bean
    public SwaggerConfig swaggerConfig() {
        return new SwaggerConfig();
    }
}
