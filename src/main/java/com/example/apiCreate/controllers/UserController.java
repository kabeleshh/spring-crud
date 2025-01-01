package com.example.apiCreate.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiCreate.models.User;
import com.example.apiCreate.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userServices.getAllUsers() ;
    }

    @GetMapping("/{id}")
    public Optional<User> getUniqueUser(@PathVariable int id){
        return userServices.getUniqueUser(id);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userServices.newUser(user);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable int id, @RequestBody User user){
        return userServices.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return userServices.deleteUser(id)?" User removed from DB successfully":"User not found";
    }
}
