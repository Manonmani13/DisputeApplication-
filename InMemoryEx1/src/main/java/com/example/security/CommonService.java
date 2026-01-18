package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class CommonService {
	
	@Bean
	public  UserDetailsService inMemoryUserDetailsService(PasswordEncoder encoder) {
		UserDetails user=User.withUsername("user")
				.password(encoder.encode("password"))
				.roles("USER")
				.build();
		UserDetails admin = org.springframework.security.core.userdetails.User
	            .withUsername("admin")
	            .password(encoder.encode("admin"))
	            .roles("ADMIN")
	            .build();

	    return new InMemoryUserDetailsManager(user, admin);
	}
	

}
