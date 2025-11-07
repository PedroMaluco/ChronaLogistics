package com.pratica.trains.dto;

public record LoginResponseDTO(String token) {

	public LoginResponseDTO(String token) {
		this.token = token;
	}

}
