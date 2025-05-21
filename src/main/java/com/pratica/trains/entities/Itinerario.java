package com.pratica.trains.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itinerario")
public class Itinerario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime inicio;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime fim;
	
	@OneToOne(mappedBy = "itinerario")
	private Locomotiva locomotiva;
	
	@ManyToMany(mappedBy = "itinerarios")
	private Set<Estacao>estaçoes = new HashSet<>();
	
	public Itinerario() {
	}

	public Itinerario(Long id, LocalDateTime inicio, LocalDateTime fim, Locomotiva locomotiva, Set<Estacao> estaçoes) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.locomotiva = locomotiva;
		this.estaçoes = estaçoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFim() {
		return fim;
	}

	public void setFim(LocalDateTime fim) {
		this.fim = fim;
	}

	public Locomotiva getLocomotiva() {
		return locomotiva;
	}

	public void setLocomotiva(Locomotiva locomotiva) {
		this.locomotiva = locomotiva;
	}

	public Set<Estacao> getEstaçoes() {
		return estaçoes;
	}
}
