package com.example.swagger;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@Tag(name = "Orders")
@SecurityRequirement(name = "jwt")
public class OrderController {

    @Operation(summary = "Get orders for user")
    @ApiResponse(responseCode = "200", description = "Orders returned")
    @GetMapping("/user/{userId}")
    public List<OrderResponse> getOrders(
            @Parameter(description = "User ID", example = "1")
            @PathVariable Long userId) {
        return List.of(new OrderResponse());
    }
}
