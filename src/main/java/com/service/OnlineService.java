package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Login;
import com.bean.Questions;
import com.bean.Quiz;


import com.repository.QuestionRepository;
import com.repository.QuizRepository;
import com.repository.LoginRepository;


@Service
public class OnlineService {
	
	@Autowired
	LoginRepository loginrepo;

	@Autowired
	QuestionRepository quesrepo;
	
	@Autowired
	QuizRepository quizrepo;
	public String storeParticipants(Login log) {
		
		Optional<Login> op = loginrepo.findById(log.getId());
		if(op.isPresent()) {
			return "User id must be unique , pls try again";
		}else {
				loginrepo.save(log);				// insert new records
				return "User registered successfully";
		}
	}

public String loginParticipants(Login log) {
	
	Optional<Login> op = loginrepo.findById(log.getId());
	if(op.isPresent()) {
		return "Login Successfully";
	}else {
							// insert new records
			return "wrong credentials , try agin!!!";
	}
}

public String adminlogin(Login log) {
	
	Optional<Login> op = loginrepo.findById(log.getId());
	if(op.isPresent()) {
		return "Login Successfully";
	}else {
						
			return "wrong credentials , try agin!!!";
	}
}

public String changeAdminPassword(Login log) {
Optional<Login> op = loginrepo.findById(log.getId());
if(op.isPresent()) {
		 	Login e	= op.get();
		 	e.setPassword(log.getPassword());
		 	loginrepo.saveAndFlush(e);			// update 	existing record update property 
		 	return "Password changed successfully";
}else {
		
		return "Password not changed , try again !!!";
}
}

public String changeParticipantsPassword(Login log) {
Optional<Login> op = loginrepo.findById(log.getId());
if(op.isPresent()) {
		 	Login e	= op.get();
		 	e.setPassword(log.getPassword());
		 	loginrepo.saveAndFlush(e);			// update 	existing record update property 
		 	return "Password changed successfully";
}else {
		
		return "Password not changed";
}
}


	

	
	
public String addQuestions(Questions quest) {
	
	Optional<Questions> op = quesrepo.findById(quest.getQid());
	if(op.isPresent()) {
		return "try adding again , this question exist";
	}else {
			quesrepo.save(quest);				// insert new records
			return "question added successfully";
	}
}

public String updateQuestions(Questions ques) {
	Optional<Questions> op = quesrepo.findById(ques.getQid());
	if(op.isPresent()) {
			 	Questions e	= op.get();
			 	e.setQuestion(ques.getQuestion());
			 	e.setOption1(ques.getOption1());
			 	e.setOption2(ques.getOption2());
			 	e.setOption3(ques.getOption3());
			 	e.setOption4(ques.getOption4());
			 	e.setAnswer(ques.getAnswer());
			 	quesrepo.saveAndFlush(e);			// update 	existing record update property 
			 	return "Question and option updated successfully";
	}else {
			
			return "Question and option not updated";
	}
}

public String deleteQuestions(int qid) {
	Optional<Questions> op = quesrepo.findById(qid);
	if(op.isPresent()) {
					Questions e = op.get();
					quesrepo.delete(e);
		return "Question deleted successfully";
	}else {
			return "Question not deleted";
	}
}




public String findQuestions(int qid) {
	Optional<Questions> op = quesrepo.findById(qid);
	if(op.isPresent()) {
		Questions e = op.get();
		return e.toString();
	}else {
		return "try to enter unique question id!!!";
	}
}

public String createQuiz(Quiz quiz) {
	
	Optional<Quiz> op = quizrepo.findById(quiz.getQuiztoken());
	if(op.isPresent()) {
		return "quiz id exits try again";
	}else {
			quizrepo.save(quiz);				// insert new records
			return "quiz create ssuccessfully";
	}
}








}
