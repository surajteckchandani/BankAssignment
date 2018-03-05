package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

public class CustomError {

	private String message;
	private int statuscode;
	private Set<String> errors = new HashSet<String>(0);
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public Set<String> getErrors() {
		return errors;
	}
	public void setErrors(Set<String> errors) {
		this.errors = errors;
	}
	
	
	
}
