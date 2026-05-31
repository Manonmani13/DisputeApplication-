//package com.example.security;
//
//import java.util.List;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfigurationSource corsSource) throws Exception {
//
//    	http
//        .cors(cors -> cors.configurationSource(corsSource)) // use our CORS config
//        .csrf(csrf -> csrf.disable()) // disable CSRF for APIs / JWT
//        .authorizeHttpRequests(auth -> auth
//            .requestMatchers("/", "/public/**").permitAll() // public endpoints
//            .anyRequest().authenticated() // everything else requires authentication
//        )
//        .oauth2Login(oauth2 -> oauth2 // enable OAuth2 login
//            .loginPage("/oauth2/authorization/google") // custom login page
//        )
//        .logout(logout -> logout
//            .logoutSuccessUrl("/") // redirect after logout
//        );
//
//    return http.build();
//    }
//}
//
