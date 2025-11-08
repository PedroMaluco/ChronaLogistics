package com.pratica.trains.entities;

public enum UserRole {
	ROLE_ENGENHEIRO_CHEFE("ADMIN"), ROLE_ENGENHEIRO_SUBALTERNO("USER");
	
	private String role;
	
	UserRole(String role){
		this.role = role;
	}

	public String getRole(String role) {
		return role;
	}
	

}
