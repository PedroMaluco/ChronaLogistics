package com.pratica.trains.entities;

public enum UserRole {
	ROLE_ENGENHEIRO_CHEFE("ROLE_ENGENHEIRO_CHEFE"), ROLE_ENGENHEIRO_SUBALTERNO("ROLE_ENGENHEIRO_SUBALTERNO");
	
	private String role;
	
	UserRole(String role){
		this.role = role;
	}

	public String getRole() {
		return this.role;
	}
	

}
