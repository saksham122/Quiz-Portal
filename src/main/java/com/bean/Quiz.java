package com.bean;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="quiz")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quiztoken;
	private int quizid;
	private String title;
	private String subject ;
	private int qid;
	@ManyToOne
    private Questions questions;
	
	public int getQuiztoken() {
		return quiztoken;
	}
	public void setQuiztoken(int quiztoken) {
		this.quiztoken = quiztoken;
	}
	public int getQuizid() {
		return quizid;
	}
	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	@Override
	public String toString() {
		return "Quiz [quiztoken=" + quiztoken + ", quizid=" + quizid + ", title=" + title + ", subject=" + subject
				+ ", qid=" + qid + "]";
	}
	
	

	
	
	
	
	

}
