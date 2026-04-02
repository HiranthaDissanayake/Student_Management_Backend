package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping (value = "/api/v1")
public class userController{
    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public UserDTO addUsers(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @GetMapping("/getusers")
    public List<UserDTO> getUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/updateuser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
       return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }
}
