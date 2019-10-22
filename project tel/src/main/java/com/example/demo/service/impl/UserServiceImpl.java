package com.example.demo.service.impl;

import com.example.demo.model.Dialog;
import com.example.demo.model.Message;
import com.example.demo.model.Users;
import com.example.demo.repository.DialogRepository;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.iface.UserService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private MessageRepository messageRepository;
    private DialogRepository dialogRepository;

    public UserServiceImpl(UserRepository userRepository, MessageRepository messageRepository, DialogRepository dialogRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.dialogRepository = dialogRepository;
    }

    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void sendMessage(String s, Users to, Users from) {
        Dialog dialog = dialogRepository.findDialogByUser1AndUser2(to.getId(), from.getId());
        if (!(dialogRepository.findDialogByUser1AndUser2(to.getId(), from.getId()) != null || dialogRepository.findDialogByUser1AndUser2(from.getId(), to.getId()) != null)) {
            dialog = dialogRepository.save(new Dialog(to.getId(), from.getId()));
        }
        if (dialog == null) {
            dialog = dialogRepository.findDialogByUser1AndUser2(from.getId(), to.getId());

        }
        Message message = messageRepository.save(new Message(from.getId(), to.getId(), dialog.getId(), s, new Timestamp(System.currentTimeMillis())));

}
}
