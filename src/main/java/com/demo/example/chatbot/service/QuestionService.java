package com.demo.example.chatbot.service;

import java.util.List;
import com.demo.example.chatbot.entity.Question;

public interface QuestionService {

	void deleteQuestion(String questionId);

	List<Question> getAllQuestions();

	Question updateQuestion(Question question);

	Question findById(String id);

	Question saveQuestion(Question question);

	List<Question> getAllQuestionsByLevel(int level);

}
