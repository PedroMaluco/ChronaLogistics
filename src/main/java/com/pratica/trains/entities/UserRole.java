package com.pratica.trains.entities;

public enum UserRole {
	ENGENHEIRO_CHEFE("ADMIN"), ENGENHEIRO_SUBALTERNO("USER");
	
	private String role;
	
	UserRole(String role){
		this.role = role;
	}

	public String getRole(String role) {
		return role;
	}
	

}
