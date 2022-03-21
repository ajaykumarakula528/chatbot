package com.demo.example.chatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.chatbot.dto.ServiceStatus;
import com.demo.example.chatbot.entity.User;
import com.demo.example.chatbot.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	@Autowired
	private UserService userservice;

	@PostMapping("/saveUser")
	public ServiceStatus save(@RequestBody User user) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			if (user.getEmail() == null || user.getEmail().isEmpty()) {
				serviceStatus.setStatus("failure");
				serviceStatus.setMessage("Email cannot be empty");
			} else if (user.getPassword() == null || user.getPassword().isEmpty()) {
				serviceStatus.setStatus("failure");
				serviceStatus.setMessage("Password cannot be empty");
			} else {
				String mail = user.getEmail();
				User existingEmailData = this.userservice.getUserByEmail(mail);
				if (existingEmailData != null) {
					serviceStatus.setStatus("failure");
					serviceStatus.setMessage("email already registered");
				} else {
					user.setEmail(user.getEmail().toLowerCase());
					User userData = this.userservice.addUser(user);
					if (userData != null) {
						serviceStatus.setResult(userData);
						serviceStatus.setStatus("sucess");
						serviceStatus.setMessage("registration successful");
					} else {
						serviceStatus.setStatus("sucess");
						serviceStatus.setMessage("failed to register");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage(e.getMessage());
			if (e instanceof org.springframework.dao.DataIntegrityViolationException) {
				serviceStatus.setMessage("DATAINTGRTY_VIOLATION");
			}

		}
		return serviceStatus;
	}

	@GetMapping("/allusers")
	public ServiceStatus getAllUsers() {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			List<User> users = this.userservice.getAllUsers();
			if (users != null && !users.isEmpty()) {
				for (User user : users) {
					user.setPassword(null);
				}
				serviceStatus.setResult(users);
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("Successfully fetched users");
			} else {
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("No users found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage(e.getMessage());
		}

		return serviceStatus;
	}

	@PutMapping("/updateUser")
	public ServiceStatus update(@RequestBody User user) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			User existingEmailData = this.userservice.getUserByEmail(user.getEmail());
			if (existingEmailData == null) {
				serviceStatus.setStatus("failure");
				serviceStatus.setMessage("Email cannot be updated or empty");
			} else {
				user.getEmail().toLowerCase();
				user.setPassword(existingEmailData.getPassword());
				User userData = this.userservice.updateUser(user);
				userData.setPassword(null);
				serviceStatus.setResult(userData);
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("Successfully updated");
			}

		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage(e.getMessage());
		}
		return serviceStatus;
	}

	@DeleteMapping("/deleteUser")
	public ServiceStatus deleteUser(@RequestParam String id) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			this.userservice.deleteUser(id);
			serviceStatus.setStatus("sucess");
			serviceStatus.setMessage("Successfully deleted");

		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage(e.getMessage());
		}
		return serviceStatus;
	}

	@GetMapping("/getUserByEmail")
	public ServiceStatus getUserByEmailId(@RequestParam String email) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			User uf = this.userservice.getUserByEmail(email);
			if (uf != null) {
				uf.setPassword(null);
				serviceStatus.setResult(uf);
				serviceStatus.setStatus("failure");
				serviceStatus.setMessage("Successfully Retrieved");
			} else {
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("No data found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage(e.getMessage());
		}
		return serviceStatus;
	}

	@GetMapping("/getUser")
	public ServiceStatus getUser(@RequestParam String id) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			User uf = this.userservice.findById(id);
			if (uf != null) {
				uf.setPassword(null);
				serviceStatus.setResult(uf);
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("Successfully Retrieved");
			} else {
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("No data found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage(e.getMessage());
		}
		return serviceStatus;
	}

	@PostMapping("/login")
	public ServiceStatus validateUser(@RequestParam String username, @RequestParam String password) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			serviceStatus = userservice.validateUser(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage(e.getMessage());
		}
		return serviceStatus;
	}

}
