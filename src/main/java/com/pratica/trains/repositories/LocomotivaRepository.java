package com.pratica.trains.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pratica.trains.entities.Locomotiva;

public interface LocomotivaRepository extends JpaRepository<Locomotiva, Long> {
	
	@Query("SELECT obj FROM Locomotiva obj WHERE UPPER(obj.nome) LIKE UPPER(CONCAT('%', :nome, '%'))")
	List<Locomotiva> search1(String nome);

}
