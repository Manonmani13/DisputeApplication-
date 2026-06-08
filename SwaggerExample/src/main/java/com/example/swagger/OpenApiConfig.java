//package com.example.swagger;
//
//import org.springframework.context.annotation.Configuration;
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.info.Info;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
//import io.swagger.v3.oas.annotations.servers.Server;
//
//@OpenAPIDefinition(
//        info = @Info(
//                title = "User & Order API",
//                version = "v1",
//                description = "API for managing users and orders"
//        ),
//        servers = {
//                @Server(url = "http://localhost:8080", description = "Local"),
//                @Server(url = "https://dev.api.com", description = "Dev"),
//                @Server(url = "https://api.com", description = "Prod")
//        }
//)
//@SecurityScheme(
//        name = "jwt",
//        type = SecuritySchemeType.HTTP,
//        scheme = "bearer",
//        bearerFormat = "JWT"
//)
//@Configuration
//public class OpenApiConfig {
//
//}
