package com.klef.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.model.User;
import com.klef.service.UserService;

@RestController
@RequestMapping("/auth")

@CrossOrigin(origins = "http://localhost:5173")

public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")

    public ResponseEntity<User> register(
            @RequestBody User user) {

        return ResponseEntity.ok(
            service.register(user));

    }
    @PostMapping("/login")

    public ResponseEntity<?> login(
            @RequestBody User user) {

        Optional<User> u =
            service.login(
                user.getUsername(),
                user.getPassword());

        if(u.isPresent()) {

            return ResponseEntity.ok(u.get());

        }

        return ResponseEntity
                .badRequest()
                .body("Invalid Credentials");

    }

    // PROFILE

    @GetMapping("/profile/{username}")

    public ResponseEntity<?> profile(
            @PathVariable String username) {

        return ResponseEntity.ok(
            service.getProfile(username));

    }
}