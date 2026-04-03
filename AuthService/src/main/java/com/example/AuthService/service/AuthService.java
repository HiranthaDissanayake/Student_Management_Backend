package com.example.AuthService.service;

import com.example.AuthService.model.User;
import com.example.AuthService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepo userRepo;

    public String register(User user){
        userRepo.save(user);
        return "User Registered Successfully";
    }

    public String login(String username, String password){
        Optional<User> user = userRepo.findByUsername(username);

        if(user.isPresent() && user.get().getPassword().equals(password)){
            return "Login Successfully";
        }else {
            return "Invalid Credentials";
        }
    }
}
