package com.example.swagger;


import io.swagger.v3.oas.annotations.media.Schema;

public class OrderResponse {

    @Schema(description = "Order ID", example = "101")
    private Long id;

    @Schema(description = "Order status", example = "CREATED")
    private String status;

    // Getters & setters
}