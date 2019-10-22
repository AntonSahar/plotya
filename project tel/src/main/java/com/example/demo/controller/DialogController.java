package com.example.demo.controller;

import com.example.demo.model.Dialog;
import com.example.demo.model.Message;
import com.example.demo.model.Users;
import com.example.demo.service.iface.DialogService;
import com.example.demo.service.iface.MessageService;
import com.example.demo.service.iface.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class DialogController {
    private DialogService dialogService;
    private UserService userService;
    private MessageService messageService;

    @Value("${welcome.message}")
    private String message;

    public DialogController(DialogService dialogService, UserService userService, MessageService messageService) {
        this.dialogService = dialogService;
        this.userService = userService;
        this.messageService = messageService;
    }

    //    @RequestMapping(value = "/dialog", method = RequestMethod.GET, produces = {"application/stream+json"})
    @GetMapping(path = "/dialog")
    public @ResponseBody Set<Users> getDialogs(Integer id){
        Set<Users> names = new HashSet<>();
        Iterable<Dialog> dialogs = dialogService.getDialogsByUser(id);
        for(Dialog d : dialogs){
            names.add(userService.findUserById(d.getUser2()));
            names.add(userService.findUserById(d.getUser1()));
        }
        if (names.contains(userService.findUserById(id))){
            names.remove(userService.findUserById(id));
        }
        return names;
    }

    public List<Message> getLastMessages(Integer id){
        Iterable<Dialog> dialogs = dialogService.getDialogsByUser(id);
        List<Message> strings = new ArrayList<>();
        for(Dialog d : dialogs){
            strings.add(messageService.getMessagesById(d.getId()).get(messageService.getMessagesById(d.getId()).size()-1));
        }
        System.out.println(strings);
        return strings;
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String personList(Model model) {
        model.addAttribute("persons", getDialogs(1));
        model.addAttribute("messages",getLastMessages(1));
        return "personList";
    }
    @RequestMapping(value = { "/admin/pageAdmin" }, method = RequestMethod.GET)
    public String pageAdmin(Model model) {
        return "pageAdmin";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
