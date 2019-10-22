package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.model.UserResponseBody;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/personList/users")
    public ResponseEntity<?> findAll() {
        UserResponseBody result = new UserResponseBody();
        List<Users> users = new ArrayList<>();
        for(Users u : userRepository.findAll()){
            users.add(u);
        }
        result.setMsg("Done");
        result.setResult(users);
        return ResponseEntity.ok(result);
    }
}
