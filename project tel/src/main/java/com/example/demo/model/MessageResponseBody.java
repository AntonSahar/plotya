package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class MessageResponseBody {

    String msg;
    List<Message> result;

}
