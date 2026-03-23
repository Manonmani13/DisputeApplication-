package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class CommonService {
	
	@Bean
	public UserDetailsService users() {
		UserDetails user1= User.withDefaultPasswordEncoder()
				.username("mano")
				.password("mano@1")
				.roles("USER")
				.build();
		
		UserDetails user2= User.withDefaultPasswordEncoder()
				.username("naveen")
				.password("naveen@1")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user1,user2);
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.
		authorizeHttpRequests(auth->auth
				.requestMatchers("/public").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
				).
		csrf(csrf-> csrf.disable())
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.httpBasic(Customizer.withDefaults());
//		.formLogin(form ->form.permitAll());
//		http
//	    .exceptionHandling(null)
//	    .authenticationManager((req, res, ex) -> res.sendError(401, "Login required"))
//	    .accessDeniedHandler((req, res, ex) -> res.sendError(403, "Not allowed"));
		return http.build();
		
	}
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	    http
//	        .csrf(csrf -> csrf.disable())
//	        .authorizeHttpRequests(auth -> auth
//	            .requestMatchers("/public").permitAll()
//	            .requestMatchers("/admin").hasRole("ADMIN")
//	            .anyRequest().authenticated()
//	        )
//	        .httpBasic(Customizer.withDefaults()) // authentication mechanism
//	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
////	        .exceptionHandling(ex -> ex
////	            .authenticationEntryPoint((request, response, authException) ->
////	                response.sendError(401, "Login required")) // 401
////	            .accessDeniedHandler((request, response, accessDeniedException) ->
////	                response.sendError(403, "Not allowed")) // 403
////	        );
//
//	    return http.build();
//	}

	

}
