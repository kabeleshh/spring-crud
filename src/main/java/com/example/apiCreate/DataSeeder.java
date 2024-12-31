package com.example.apiCreate;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.apiCreate.models.User;
import com.example.apiCreate.repositories.UserRepo;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void run(String ...args) throws Exception {
        if(userRepo.count()==0){
            List<User> user = Arrays.asList(
            new User("abcd","qwertyu"),
            new User("defg","asdffgh")
        );
        userRepo.saveAll(user);
        }
    }
}
