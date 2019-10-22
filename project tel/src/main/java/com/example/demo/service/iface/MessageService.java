package com.example.demo.service.iface;

import com.example.demo.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getMessagesById(Integer id);
}
