package com.demo.example.chatbot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.example.chatbot.entity.Answer;

@Repository
public interface AnswerRepository extends MongoRepository<Answer, String> {

	Answer save(Answer answer);

	List<Answer> findAllByUserId(String userId);

	List<Answer> findAllByQuestionId(String questionId);

	List<Answer> findAllByQuestionName(String questionName);

}
