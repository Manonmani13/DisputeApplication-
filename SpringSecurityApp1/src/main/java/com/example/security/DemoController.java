package com.example.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/public")
    public String publicPage() {
        return "Public page";
    }

    @GetMapping("/user")
    public String userPage() {
        return "User page (logged in)";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "Admin page (ADMIN only)";
    }
    
    @GetMapping("/me")
    public String currentUser() {
        // Get authentication object from SecurityContext
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        // Get principal (username)
        String username = auth.getName();
        
        // Get authorities (roles/permissions)
        String roles = auth.getAuthorities().toString();

        return "Current User: " + username + ", Roles: " + roles;
    }
    
    @GetMapping("/profile")
    public String profile() {
        Authentication auth =
        SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName()	);
        return auth.getName(); // alice
    }

}

