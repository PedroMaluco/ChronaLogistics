package com.pratica.trains.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratica.trains.dto.AuthDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping(value = "/login")
	public ResponseEntity login (@RequestBody @Valid AuthDTO dto) {
		var userPassword = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha());
		var auth = this.authenticationManager.authenticate(userPassword);
		
		return ResponseEntity.ok().build();
	}

}
