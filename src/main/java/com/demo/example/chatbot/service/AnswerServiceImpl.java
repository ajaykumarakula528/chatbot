package com.demo.example.chatbot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.chatbot.entity.Answer;
import com.demo.example.chatbot.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public Answer saveAnswer(Answer answer) {
		return answerRepository.save(answer);
	}

	@Override
	public List<Answer> getAllAnswers() {
		return answerRepository.findAll();
	}

	@Override
	public Answer updateAnswer(Answer answer) {
		return answerRepository.save(answer);
	}

	@Override
	public void deleteAnswer(String answerId) {
		answerRepository.deleteById(answerId);
	}

	@Override
	public List<Answer> getAllAnswersByUserId(String userId) {
		return answerRepository.findAllByUserId(userId);
	}

	@Override
	public List<Answer> getAllAnswersByQuestionId(String questionId) {
		return answerRepository.findAllByQuestionId(questionId);
	}

	@Override
	public Answer findById(String id) {
		Optional<Answer> answer = answerRepository.findById(id);
		if (answer.isPresent())
			return answer.get();
		else
			return null;
	}

	@Override
	public List<Answer> getAllAnswersByQuestionName(String questionName) {
		return answerRepository.findAllByQuestionName(questionName);
	}

}
