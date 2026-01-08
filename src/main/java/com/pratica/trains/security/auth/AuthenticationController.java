package com.pratica.trains.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratica.trains.dto.LogInDTO;
import com.pratica.trains.dto.RegisterDTO;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> register(@RequestBody RegisterDTO dto){
		String response = authenticationService.register(dto);
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<String> authenticate(@RequestBody LogInDTO dto){
		String response = authenticationService.authenticate(dto);
		return ResponseEntity.ok().body(response);
	}
}
