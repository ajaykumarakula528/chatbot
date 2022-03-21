package com.demo.example.chatbot.service;

import java.util.List;

import com.demo.example.chatbot.entity.Answer;

public interface AnswerService {
	Answer saveAnswer(Answer answer);

	List<Answer> getAllAnswers();

	Answer updateAnswer(Answer answer);

	void deleteAnswer(String answerId);

	Answer findById(String id);

	List<Answer> getAllAnswersByUserId(String userId);

	List<Answer> getAllAnswersByQuestionId(String questionId);

	List<Answer> getAllAnswersByQuestionName(String questionName);
}
