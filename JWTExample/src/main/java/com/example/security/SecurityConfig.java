package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	 private final JwtFilter jwtFilter;
	    private final CustomUserDetailsService userDetailsService;

	    public SecurityConfig(JwtFilter jwtFilter, CustomUserDetailsService userDetailsService) {
	        this.jwtFilter = jwtFilter;
	        this.userDetailsService = userDetailsService;
	    }
	    
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/register", "/login").permitAll()
	                .requestMatchers("/admin/**").hasRole("ADMIN")
	                .anyRequest().authenticated()
	            )
	            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

	        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
	    
	    @Bean
	    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
	        return http.getSharedObject(AuthenticationManagerBuilder.class)
	                .userDetailsService(userDetailsService)
	                .passwordEncoder(passwordEncoder)
	                .and()
	                .build();
	    }
}
