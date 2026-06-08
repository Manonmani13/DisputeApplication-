package com.example.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public class LoginResponse {
	 @Schema(description = "JWT token", example = "eyJhbGciOi...")
	    private String token;

	    public LoginResponse(String token) {
	        this.token = token;
	    }

	    public String getToken() { return token; }
	    public void setToken(String token) { this.token = token; }
}
