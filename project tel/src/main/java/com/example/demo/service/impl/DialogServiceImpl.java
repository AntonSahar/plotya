package com.example.demo.service.impl;

import com.example.demo.model.Dialog;
import com.example.demo.repository.DialogRepository;
import com.example.demo.repository.MessageRepository;
import com.example.demo.service.iface.DialogService;
import org.springframework.stereotype.Service;

@Service
public class DialogServiceImpl implements DialogService {
    private DialogRepository dialogRepository;
    private MessageRepository messageRepository;

    public DialogServiceImpl(DialogRepository dialogRepository, MessageRepository messageRepository) {
        this.dialogRepository = dialogRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public void sendMessage(String message) {

    }

    @Override
    public Iterable<Dialog> getDialogs() {
        return null;
    }

    @Override
    public Iterable<Dialog> getDialogsByUser(Integer id) {
        return dialogRepository.getDialogsByUser1OrUser2(id,id);
    }
}
