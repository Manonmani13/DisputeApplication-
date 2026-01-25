package com.example.swagger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication")
public class AuthController {
	
	@Operation(summary = "Login user")
    @ApiResponse(responseCode = "200", description = "Login successful")
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        // In real app: authenticate and generate JWT
        return new LoginResponse("fake-jwt-token");
    }

}
