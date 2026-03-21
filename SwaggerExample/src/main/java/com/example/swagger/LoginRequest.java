package com.example.swagger;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class LoginRequest {
	@Schema(description = "User email", example = "test@test.com")
    @NotNull
    private String email;

    @Schema(description = "User password", example = "Secret123")
    @NotNull
    private String password;

    // Getters & Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
