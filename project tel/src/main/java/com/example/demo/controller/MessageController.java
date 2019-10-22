package com.example.demo.controller;

import com.example.demo.model.MessageResponseBody;
import com.example.demo.model.Message;
import com.example.demo.service.iface.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/personList/messages")
    public ResponseEntity<?> findAll(Integer id) {
        MessageResponseBody result = new MessageResponseBody();
        List<Message> messages = new ArrayList<>();
        for(Message m : messageService.getMessagesById(id)){
            messages.add(m);
        }
        result.setMsg("Done");
        result.setResult(messages);
        return ResponseEntity.ok(result);
    }
}
