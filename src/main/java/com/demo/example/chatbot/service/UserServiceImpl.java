package com.demo.example.chatbot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.example.chatbot.dto.ServiceStatus;
import com.demo.example.chatbot.entity.User;
import com.demo.example.chatbot.loginvalidation.LoginValidationDetails;
import com.demo.example.chatbot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> usersList = userRepository.findAll();
		return usersList;
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);

	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public ServiceStatus validateUser(String email, String password) {
		ServiceStatus serviceStatus = new ServiceStatus();
		if (email != null) {
			User userData = userRepository.findByEmail(email);
			if (userData != null) {
				String userPassword = userData.getPassword();
				if (userPassword != null) {
					if (userPassword.equals(password)) {
						LoginValidationDetails validationDetails = new LoginValidationDetails();
						validationDetails.setId(userData.getId());
						validationDetails.setFirstName(userData.getFirstname());
						validationDetails.setLastName(userData.getLastname());
						validationDetails.setEmail(userData.getEmail());
						validationDetails.setRole(userData.getRole());
						serviceStatus.setResult(validationDetails);
						serviceStatus.setStatus("sucess");
						serviceStatus.setMessage("Login Successful");
						return serviceStatus;
					} else {
						serviceStatus.setStatus("failure");
						serviceStatus.setMessage("Invalid Credentials");
						return serviceStatus;
					}
				}
			} else {
				serviceStatus.setStatus("failure");
				serviceStatus.setMessage("Invalid Credentials");
				return serviceStatus;
			}

		} else {
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage("failure");
			return serviceStatus;
		}
		return serviceStatus;
	}

	@Override
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent())
			return user.get();
		else
			return null;
	}

}
