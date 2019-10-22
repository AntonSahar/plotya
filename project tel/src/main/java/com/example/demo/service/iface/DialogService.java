package com.example.demo.service.iface;

import com.example.demo.model.Dialog;
import org.springframework.stereotype.Service;

@Service
public interface DialogService {
    void sendMessage(String message);

    Iterable<Dialog> getDialogs();

    Iterable<Dialog> getDialogsByUser(Integer id);
}
