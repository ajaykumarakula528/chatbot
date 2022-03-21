package com.demo.example.chatbot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.chatbot.entity.Question;
import com.demo.example.chatbot.repository.QuestionRepository;

@Service
public class QuestionServiceimpl implements QuestionService {
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public Question updateQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public void deleteQuestion(String questionId) {
		questionRepository.deleteById(questionId);
	}

	@Override
	public Question findById(String id) {
		Optional<Question> question = questionRepository.findById(id);
		if (question.isPresent())
			return question.get();
		else
			return null;
	}

	@Override
	public List<Question> getAllQuestionsByLevel(int level) {
		return questionRepository.findAllByLevel(level);
	}
}
