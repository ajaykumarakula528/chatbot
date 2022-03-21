package com.demo.example.chatbot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.example.chatbot.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);

}
