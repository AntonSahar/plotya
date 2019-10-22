package com.example.demo.service.iface;

import com.example.demo.model.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void sendMessage(String s, Users to, Users from);

    Iterable<Users> findAll();

    Users findUserById(Integer id);
}
