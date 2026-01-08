package com.pratica.trains.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pratica.trains.dto.LogInDTO;
import com.pratica.trains.dto.RegisterDTO;
import com.pratica.trains.entities.Maquinista;
import com.pratica.trains.entities.UserRole;
import com.pratica.trains.repositories.MaquinistaRepository;
import com.pratica.trains.security.config.JWTService;
import com.pratica.trains.token.Token;
import com.pratica.trains.token.TokenRepository;
import com.pratica.trains.token.TokenType;

@Service
public class AuthenticationService {
	
	@Autowired
	private PasswordEncoder passwordEnconder;
	@Autowired
	private TokenRepository tokenRepository;
	@Autowired
	private MaquinistaRepository maquinistaRepository;
	@Autowired
	private JWTService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Transactional
	public String register(RegisterDTO dto) {
		Maquinista newUser = new Maquinista();
		newUser.setNome(dto.getNome());
		newUser.setIdade(dto.getIdade());
		newUser.setEmail(dto.getEmail());
		String encodedPassword = passwordEnconder.encode(dto.getSenha());
		newUser.setSenha(encodedPassword);
		newUser.setRole(UserRole.ENGENHEIRO_USUARIO);
		maquinistaRepository.save(newUser);
		var token = jwtService.generateToken(newUser);
		saveToken(newUser, token);
		return token;
	}
	@Transactional
	public String authenticate(LogInDTO dto) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						dto.getEmail(), dto.getPassword()
						)
				);
		
		var user = maquinistaRepository.findByEmail(dto.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		nullifyAllTokens(user);
		saveToken(user, jwtToken);
		return jwtToken;
	}
	
	@Transactional
	private void saveToken(Maquinista user, String jwtToken) {
		Token tokenEntity = new Token();
		tokenEntity.setExpired(false);
		tokenEntity.setRevoked(false);
		tokenEntity.setToken(jwtToken);
		tokenEntity.setMaquinista(user);
		tokenEntity.setTokenType(TokenType.BEARER);
		tokenRepository.save(tokenEntity);
	}
	@Transactional
	public void nullifyAllTokens(Maquinista user) {
		var validTokens = tokenRepository.findAllTokensByUser(user.getEmail());
		if (validTokens.isEmpty()){
			return;
		}
		else {
			validTokens.forEach(token -> {token.setExpired(true);  token.setRevoked(true);});
			tokenRepository.saveAll(validTokens);
		}
	}
}
