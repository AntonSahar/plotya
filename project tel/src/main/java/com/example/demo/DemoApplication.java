package com.example.demo;

import com.example.demo.repository.DialogRepository;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.iface.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication  {



	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class,args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		DialogRepository dialogRepository = context.getBean(DialogRepository.class);
		MessageRepository messageRepository = context.getBean(MessageRepository.class);
		UserService userService = new UserServiceImpl(userRepository,messageRepository,dialogRepository);
		//userService.sendMessage("?",userRepository.findById(2).get(),userRepository.findById(1).get());
		//userService.sendMessage("2-1",userRepository.findById(2).get(),userRepository.findById(1).get());
		//userService.sendMessage("1-4",userRepository.findById(1).get(),userRepository.findById(4).get());
		//userService.sendMessage("hello",userRepository.findById(3).get(),userRepository.findById(1).get());


	}

}
