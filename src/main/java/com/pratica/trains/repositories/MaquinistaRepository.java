package com.pratica.trains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica.trains.entities.Maquinista;

public interface MaquinistaRepository extends JpaRepository<Maquinista, Long> {
	
}
