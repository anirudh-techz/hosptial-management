package com.example.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.entity.User;
import com.example.hospital.repository.UserRepo;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepo userrepo;

    @Autowired
    private PasswordEncoder passwordencoder;

    @PostMapping
    public String registerUser(@RequestBody User user) {
        user.setPassword(passwordencoder.encode(user.getPassword()));
        userrepo.save(user);
        return "User registered successfully";
    }
}
