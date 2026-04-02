package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    //add new user service
    public UserDTO addUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    //get all users service
    public List<UserDTO> getAllUsers(){
        List<User>userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    //update existing user service
    public UserDTO updateUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getId())) {
            userRepo.save(modelMapper.map(userDTO, User.class));
            return userDTO;
        }
        return null;
    }

    //delete existing user service
    public String deleteUser(int id){
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return "Student removed successfully";
        }
        else {
            return "Student can't find";
        }
    }


}
