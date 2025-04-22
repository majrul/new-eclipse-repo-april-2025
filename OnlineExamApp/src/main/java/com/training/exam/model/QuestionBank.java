package com.training.exam.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {

	private Map<String, List<Question>> questionBank;// = new HashMap<String, List<Question>>();

	public QuestionBank() {
		questionBank = new HashMap<String, List<Question>>();
	}
	
	public void addNewSubject(String subject) {
		questionBank.put(subject, new ArrayList<Question>());
	}

	public void addNewQuestion(String subject, Question question) {
		List<Question> questions = questionBank.get(subject);
		questions.add(question);
	}
	
	public List<Question> getQuestionsFor(String subject) {
		List<Question> questions = questionBank.get(subject);
		return questions;
	}
}
