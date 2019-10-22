package com.example.demo.service.impl;

import com.example.demo.model.Message;
import com.example.demo.repository.DialogRepository;
import com.example.demo.repository.MessageRepository;
import com.example.demo.service.iface.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;
    private DialogRepository dialogRepository;

    public MessageServiceImpl(MessageRepository messageRepository, DialogRepository dialogRepository) {
        this.messageRepository = messageRepository;
        this.dialogRepository = dialogRepository;
    }

    @Override
    public List<Message> getMessagesById(Integer id) {
        List<Message> messages = new ArrayList<>();
        Iterable<Message> iterable = messageRepository.findMessagesByDialog(dialogRepository.findById(id).get().getId());
        for(Message m : iterable){
            messages.add(m);
        }
        return messages;
    }
}
