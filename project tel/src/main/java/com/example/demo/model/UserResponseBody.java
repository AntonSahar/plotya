package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseBody {

    String msg;
    List<Users> result;

}
