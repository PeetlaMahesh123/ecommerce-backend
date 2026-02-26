package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User register(User user) {

        Optional<User> existing = repository.findByEmail(user.getEmail());

        if(existing.isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        return repository.save(user);
    }

    public User login(String email, String password) {

        User user = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }

}