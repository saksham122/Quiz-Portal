package com.controller;

import java.util.List;



import com.bean.Login;
import com.bean.Questions;
import com.bean.Quiz;
import com.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import com.service.OnlineService;

@RestController
public class MainController {
	
	
	@Autowired
	LoginRepository loginrepo;
	@Autowired
	OnlineService service;
	
	
	//http://localhost:8383/participants/signup
	@RequestMapping(value = "/participants/signup",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public String storeParticipants(@RequestBody Login log) {		// scan the value from reqeust body in the form json 
		return service.storeParticipants(log);
	}
	
	//http://localhost:8383/participants/login
	@RequestMapping(value = "/participants/login",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public String loginParticipants(@RequestBody Login log) {		// scan the value from reqeust body in the form json 
		return service.loginParticipants(log);
	}
	
	//http://localhost:8383/admin/login
	@RequestMapping(value = "/admin/login",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public String adminlogin(@RequestBody Login log) {		// scan the value from reqeust body in the form json 
		return service.adminlogin(log);
	}
	
	//http://localhost:8383/admin/changePassword
	@RequestMapping(value="/admin/changePassword", consumes=MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.PUT)
	public String changeAdminPassword(@RequestBody Login log) {
		return service.changeAdminPassword(log);
	}
	
	//http://localhost:8383/participants/changePassword
	@RequestMapping(value="/participants/changePassword", consumes=MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.PUT)
	public String changeParticipantsPassword(@RequestBody Login log) {
		return service.changeParticipantsPassword(log);
	}
	
	//http://localhost:8383/admin/addQuestions
	@RequestMapping(value = "/admin/addQuestions",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public String addQuestions(@RequestBody Questions ques) {		// scan the value from reqeust body in the form json 
		return service.addQuestions(ques);
	}
	
	//http://localhost:8383/admin/updateQuestions
		@RequestMapping(value="/admin/updateQuestions", consumes=MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.PUT)
		public String updateQuestions(@RequestBody Questions ques) {
			return service.updateQuestions(ques);
		}
	
		
	//http://localhost:8383/admin/findQuestionsById
	@RequestMapping(value="admin/findQuestionsById/{qid}", method=RequestMethod.GET , consumes=MediaType.APPLICATION_JSON_VALUE)
	public String findQuestions(@PathVariable("qid") int qid) {
		return service.findQuestions(qid);
	}
	
	//http://localhost:8383/admin/createQuiz
	@RequestMapping(value = "/admin/createQuiz",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public String addQuestions(@RequestBody Quiz quiz) {		// scan the value from reqeust body in the form json 
		return service.createQuiz(quiz);
	}
    
	
	
	
	
	
	
	
}
	 


