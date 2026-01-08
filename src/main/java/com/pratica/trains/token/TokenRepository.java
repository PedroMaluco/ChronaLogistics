package com.pratica.trains.token;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Long> {
	
	@Query(nativeQuery = true, value = "SELECT TB_TOKEN.* FROM TB_TOKEN INNER JOIN TB_MAQUINISTA ON TB_TOKEN.MAQUINISTA_ID = TB_MAQUINISTA.ID WHERE TB_MAQUINISTA.EMAIL = :email")
	List<Token> findAllTokensByUser(String email);
	
	Optional<Token> findByToken(String token);

}
