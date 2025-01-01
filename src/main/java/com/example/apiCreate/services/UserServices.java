package com.example.apiCreate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiCreate.models.User;
import com.example.apiCreate.repositories.UserRepo;

@Service
public class UserServices {

    //ArrayList<User> users = new ArrayList<>();

    @Autowired
    private UserRepo userRepo;

    public UserServices(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> getUniqueUser(int id){
        return userRepo.findById(id);
    }
    
    public User newUser(User user){
        return userRepo.save(user);
    }

    public User updateUser(int id, User user){
        User actualUser = userRepo.findById(id).orElseThrow();
        actualUser.setName(user.getName());
        actualUser.setAddress(user.getAddress());
        return userRepo.save(actualUser);
    }

    public boolean deleteUser(int id){
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
