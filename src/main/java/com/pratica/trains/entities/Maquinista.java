package com.pratica.trains.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_maquinista")
public class Maquinista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer idade;
	private Double soldo;
	private String email;
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private Set<Role>roles = new HashSet<>();
	
	
	@OneToOne(mappedBy = "maquinista", cascade = CascadeType.ALL)
	private Locomotiva locomotiva;
	
	public Maquinista() {
		
	}

	public Maquinista(Long id, String nome, Integer idade, Double soldo, String email) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.soldo = soldo;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Double getSoldo() {
		return soldo;
	}

	public void setSoldo(Double soldo) {
		this.soldo = soldo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
