package com.demo.example.chatbot.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.demo.example.chatbot.dto.ServiceStatus;
import com.demo.example.chatbot.entity.User;

@Service
public interface UserService {

	User addUser(User user);

	List<User> getAllUsers();

	User updateUser(User user);

	void deleteUser(String id);

	User getUserByEmail(String email);

	User findById(String id);

	ServiceStatus validateUser(String email, String password);

}
