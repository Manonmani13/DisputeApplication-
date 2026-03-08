package com.example.security;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletResponse;
@RestController
public class TestController {

    @Value("${google.client-id}")
    private String clientId;

    @Value("${google.client-secret}")
    private String clientSecret;

    @Value("${google.redirect-uri}")
    private String redirectUri;

    @GetMapping("/login")
    public void login(HttpServletResponse response) throws IOException {

        String googleAuthUrl =
            "https://accounts.google.com/o/oauth2/v2/auth" +
            "?client_id=" + clientId +
            "&redirect_uri=" + redirectUri +
            "&response_type=code" +
            "&scope=openid email profile";

        response.sendRedirect(googleAuthUrl);
    }

    @GetMapping("/callback")
    public ResponseEntity<String> callback(@RequestParam String code) {

        RestTemplate restTemplate = new RestTemplate();

        // 1️⃣ Build token request body
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("code", code);
        body.add("grant_type", "authorization_code");
        body.add("redirect_uri", redirectUri);

        // 2️⃣ Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request =
            new HttpEntity<>(body, headers);

        // 3️⃣ Exchange code for token
        ResponseEntity<Map<String, Object>> tokenResponse =
            restTemplate.postForEntity(
                "https://oauth2.googleapis.com/token",
                request,
                (Class<Map<String, Object>>)(Class<?>)Map.class
            );

        // 4️⃣ Extract access token
        String accessToken =
            (String) tokenResponse.getBody().get("access_token");

        // 5️⃣ Call Google userinfo API
        HttpHeaders userHeaders = new HttpHeaders();
        userHeaders.setBearerAuth(accessToken);

        HttpEntity<Void> userRequest =
            new HttpEntity<>(userHeaders);

        ResponseEntity<String> userInfo =
            restTemplate.exchange(
                "https://www.googleapis.com/oauth2/v2/userinfo",
                HttpMethod.GET,
                userRequest,
                String.class
            );

        return ResponseEntity.ok(userInfo.getBody());
    }
}

