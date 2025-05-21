package com.pratica.trains.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estacao")
public class Estacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@ManyToMany
	@JoinTable(name = "tb_estacao_itinerario",
	joinColumns = @JoinColumn(name = "estacao_id"),
	inverseJoinColumns = @JoinColumn(name = "itinerario_id"))
	private Set<Itinerario>itinerarios = new HashSet<>();
	
	@OneToMany(mappedBy = "estacao", cascade = CascadeType.ALL)
	private Set<Locomotiva>locomotivas = new HashSet<>();
	
	public Estacao() {
	}

	public Estacao(Long id, String nome, Set<Itinerario> itinerarios, Set<Locomotiva> locomotivas) {
		this.id = id;
		this.nome = nome;
		this.itinerarios = itinerarios;
		this.locomotivas = locomotivas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Itinerario> getItinerarios() {
		return itinerarios;
	}

	public Set<Locomotiva> getLocomotivas() {
		return locomotivas;
	}
}
