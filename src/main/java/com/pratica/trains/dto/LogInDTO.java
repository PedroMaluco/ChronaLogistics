package com.pratica.trains.dto;

public class LogInDTO {
	
	private String email;
	private String password;
	
	public LogInDTO() {
	}

	public LogInDTO(String username, String password) {
		this.email = username;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setUsername(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
