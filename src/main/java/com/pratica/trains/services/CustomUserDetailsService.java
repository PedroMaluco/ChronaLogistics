package com.pratica.trains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pratica.trains.entities.Maquinista;
import com.pratica.trains.repositories.MaquinistaRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MaquinistaRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Maquinista maquinista = repository.loadUserByEmail(email);
		return User.builder()
				.username(maquinista.getEmail())
				.password(maquinista
				.getSenha())
				.roles(maquinista.getRoles())
				.build();
	}

}
