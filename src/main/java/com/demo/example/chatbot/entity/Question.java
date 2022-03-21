package com.demo.example.chatbot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Question {

	@Id
	private String id;
	private String questionName;
	private String description;
	private int level;

	public Question() {
		super();
	}

	public Question(String id, String questionName, String description, int level) {
		super();
		this.id = id;
		this.questionName = questionName;
		this.description = description;
		this.level = level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionName=" + questionName + ", description=" + description + ", level="
				+ level + ", getId()=" + getId() + ", getQuestionName()=" + getQuestionName() + ", getDescription()="
				+ getDescription() + ", getLevel()=" + getLevel() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}