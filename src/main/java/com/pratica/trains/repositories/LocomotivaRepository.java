package com.pratica.trains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica.trains.entities.Locomotiva;

public interface LocomotivaRepository extends JpaRepository<Locomotiva, Long> {

}
