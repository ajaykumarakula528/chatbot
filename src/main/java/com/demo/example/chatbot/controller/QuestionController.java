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
import com.demo.example.chatbot.entity.Question;
import com.demo.example.chatbot.service.QuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@PostMapping("/saveQuestions")
	public ServiceStatus save(@RequestBody Question question) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			if (question.getId() == null || question.getId().isEmpty()) {
				serviceStatus.setStatus("failure");
				serviceStatus.setMessage("Invalid Data,Id must not be null or empty");
				return serviceStatus;
			}
			Question questionData = questionService.saveQuestion(question);
			if (questionData != null) {
				serviceStatus.setResult(questionData);
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("Successfully saved");
			} else {
				serviceStatus.setStatus("failure");
				serviceStatus.setMessage("failed to save ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage(e.getMessage());
		}
		return serviceStatus;
	}

	@GetMapping("/getAllQuestions")
	public ServiceStatus getAllQuestions() {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			List<Question> questions = questionService.getAllQuestions();
			if (questions != null && !questions.isEmpty()) {
				serviceStatus.setResult(questions);
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("Successfully retrieved");
			} else {
				serviceStatus.setStatus("failure");
				serviceStatus.setMessage("failed to retrieve");
			}
		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage(e.getMessage());
		}
		return serviceStatus;
	}

	@PutMapping("/updateQuestions")
	public ServiceStatus updateQuestion(@RequestBody Question question) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			Question questionData = questionService.updateQuestion(question);
			if (questionData != null) {
				serviceStatus.setResult(questionData);
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("Successfully updated");
			} else {
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("failed to update ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage(e.getMessage());
		}
		return serviceStatus;

	}

	@DeleteMapping("/deleteQuestion")
	public ServiceStatus deleteQuestion(@RequestParam String questionId) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			questionService.deleteQuestion(questionId);
			serviceStatus.setStatus("sucess");
			serviceStatus.setMessage("deleted sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage("failed to delete");
		}

		return serviceStatus;

	}

	@GetMapping("/getQuestion")
	public ServiceStatus getQuestion(@RequestParam String id) {
		ServiceStatus serviceStatus = new ServiceStatus();

		try {
			Question question = questionService.findById(id);
			if (question != null) {
				serviceStatus.setResult(question);
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("Successfully retrieved");
			} else {
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("No data found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("sucess");
			serviceStatus.setMessage(e.getMessage());
		}
		return serviceStatus;
	}

	@GetMapping("/getAllQuestionsByLevel")
	public ServiceStatus getAllQuestionsByLevel(@RequestParam("level") int level) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			List<Question> questions = questionService.getAllQuestionsByLevel(level);
			if (questions != null && !questions.isEmpty()) {
				serviceStatus.setResult(questions);
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("Successfully retrieved");
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
}
