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
import com.pratica.trains.dto.LoginResponseDTO;
import com.pratica.trains.entities.Maquinista;
import com.pratica.trains.services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping(value = "/login")
	public ResponseEntity login (@RequestBody @Valid AuthDTO dto) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((Maquinista)auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}

}
