package com.example.AuthService.controller;

import com.example.AuthService.model.User;
import com.example.AuthService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthControler {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        return authService.register(user);
    }

    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        return authService.login(username,password);
    }
}
