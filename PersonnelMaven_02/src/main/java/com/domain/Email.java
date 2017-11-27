package com.domain;

public class Email {

	private String subjectName;
	private String emailNumber;
	private String content;
	public Email() {
		super();
	}
	
	public Email(String subjectName, String emailNumber, String content) {
		super();
		this.subjectName = subjectName;
		this.emailNumber = emailNumber;
		this.content = content;
	}

	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getEmailNumber() {
		return emailNumber;
	}
	public void setEmailNumber(String emailNumber) {
		this.emailNumber = emailNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
