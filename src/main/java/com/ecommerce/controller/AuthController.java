package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService service;

    // ✅ REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    // ✅ LOGIN (THIS IS MISSING IN YOUR CODE)
    @PostMapping("/login")
    public User login(
            @RequestParam String email,
            @RequestParam String password) {

        return service.login(email, password);
    }
}