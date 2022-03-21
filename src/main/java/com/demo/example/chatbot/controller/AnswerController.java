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
import com.demo.example.chatbot.entity.Answer;
import com.demo.example.chatbot.service.AnswerService;

@RestController
@RequestMapping("/answers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnswerController {
	@Autowired
	private AnswerService answerService;

	@PostMapping("/saveAnswers")
	public ServiceStatus save(@RequestBody Answer answer) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			if (answer.getAnswer() == null || answer.getAnswer().isEmpty()) {
				serviceStatus.setStatus("failure");
				serviceStatus.setMessage("Invalid Data,Answer must not be null or empty");
				return serviceStatus;
			}
			Answer answerData = answerService.saveAnswer(answer);
			if (answerData != null) {
				serviceStatus.setResult(answerData);
				serviceStatus.setStatus("sucess");
				serviceStatus.setMessage("Successfully saved");
			} else {
				serviceStatus.setStatus("failure");
				serviceStatus.setMessage("failed to save ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("sucess");
			serviceStatus.setMessage(e.getMessage());
		}
		return serviceStatus;
	}

	@GetMapping("/getAllAnswers")
	public ServiceStatus getAllAnswers() {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			List<Answer> answers = answerService.getAllAnswers();
			if (answers != null && !answers.isEmpty()) {
				serviceStatus.setResult(answers);
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

	@PutMapping("/updateAnswers")
	public ServiceStatus updateAnswers(@RequestBody Answer answer) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			Answer answerData = answerService.updateAnswer(answer);
			if (answerData != null) {
				serviceStatus.setResult(answerData);
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

	@DeleteMapping("/deleteAnswer")
	public ServiceStatus deleteAnswer(@RequestParam String answerId) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			answerService.deleteAnswer(answerId);
			serviceStatus.setStatus("sucess");
			serviceStatus.setMessage("deleted sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage("failed to delete");
		}

		return serviceStatus;

	}

	@GetMapping("/getAnswer")
	public ServiceStatus getAnswer(@RequestParam String id) {
		ServiceStatus serviceStatus = new ServiceStatus();

		try {
			Answer answer = answerService.findById(id);
			if (answer != null) {
				serviceStatus.setResult(answer);
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

	@GetMapping("/getAllAnswersByUserId")
	public ServiceStatus getAllAnswersByUserId(@RequestParam("userId") String userId) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			List<Answer> answers = answerService.getAllAnswersByUserId(userId);
			if (answers != null && !answers.isEmpty()) {
				serviceStatus.setResult(answers);
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

	@GetMapping("/getAllAnswersByQuestionName")
	public ServiceStatus getAllAnswersByQuestionName(@RequestParam("questionName") String questionName) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			List<Answer> answers = answerService.getAllAnswersByQuestionName(questionName);
			if (answers != null && !answers.isEmpty()) {
				serviceStatus.setResult(answers);
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

	@GetMapping("/getAllAnswersByQuestionId")
	public ServiceStatus getAllAnswersByQuestionId(@RequestParam("questionId") String questionId) {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			List<Answer> answers = answerService.getAllAnswersByQuestionId(questionId);
			if (answers != null && !answers.isEmpty()) {
				serviceStatus.setResult(answers);
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
