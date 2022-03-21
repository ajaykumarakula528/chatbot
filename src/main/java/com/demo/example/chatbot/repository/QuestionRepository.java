package com.demo.example.chatbot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.example.chatbot.entity.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {

	Question save(Question question);

	List<Question> findAllByLevel(int level);

}
