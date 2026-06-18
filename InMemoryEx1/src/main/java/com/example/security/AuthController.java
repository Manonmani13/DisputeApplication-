package com.example.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	
	public AuthController(AuthenticationManager authenticationManager) {
		this.authenticationManager=authenticationManager;
	}
	
	@PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password)
        );
        if (auth.isAuthenticated()) {
            return "Login successful for " + username;
        }
        return "Login failed";
    }

}
