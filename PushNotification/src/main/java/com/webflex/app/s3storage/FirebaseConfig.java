package com.webflex.app.s3storage;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void init() throws Exception {


        InputStream serviceAccount =
                getClass().getClassLoader().getResourceAsStream("firebase.json");

        if (serviceAccount == null) {
            throw new RuntimeException("firebase.json not found");
        }

        System.out.println("✅ FILE FOUND");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
        System.out.println("✅ Firebase Initialized");

    }
}
