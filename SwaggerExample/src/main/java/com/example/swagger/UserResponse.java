package com.example.swagger;


import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserResponse {

    @Schema(description = "User ID", example = "1")
    private Long id;

    @Schema(description = "User email", example = "test@test.com")
    private String email;

    @Hidden
    private String internalFlag; // hidden in Swagger

    // Getters & setters
}
