package com.pratica.trains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pratica.trains.entities.Maquinista;

public interface MaquinistaRepository extends JpaRepository<Maquinista, Long> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM tb_maquinista WHERE tb_maquinista.email = :email")
	Maquinista loadUserByEmail(String email);
	
}
