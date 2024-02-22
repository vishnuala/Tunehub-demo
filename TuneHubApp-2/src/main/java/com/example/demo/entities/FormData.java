package com.example.demo.entities;

public class FormData {
	
	String username;
	String email;
	String password;
	
	public FormData() {
		
	}

	public FormData(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "FormData [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	

}
