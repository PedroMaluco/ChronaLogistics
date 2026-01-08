package com.pratica.trains.entities;

public enum UserRole {
	
	ENGENHEIRO_USUARIO("ENGENHEIRO_USUARIO"), 
	
	ENGENHEIRO_CHEFE("ENGENHEIRO_CHEFE");
	
	private String role;

	UserRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
}
