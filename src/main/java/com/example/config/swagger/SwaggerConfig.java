package com.example.config.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Alisher Odilov
 * Date: 27.07.2023
 */
@Configuration
//@OpenAPIDefinition(info = @Info(title = "DoniyorShifo.uz APi documentation", version = "1.0", description = ""),servers = {@Server(url = "https://api.doniyor.doniyorshifo.uz/", description = "Default Server URL")})
@OpenAPIDefinition(info = @Info(title = "DoniyorShifo.uz APi documentation", version = "1.0", description = ""))
@ConditionalOnProperty(value = "springfox.documentation.enabled", havingValue = "true", matchIfMissing = true)
@SecurityScheme(name = "Bearer Authentication", type = SecuritySchemeType.HTTP, bearerFormat = "JWT",scheme = "bearer")
public class    SwaggerConfig {

}