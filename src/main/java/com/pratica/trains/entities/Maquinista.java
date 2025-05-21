package com.pratica.trains.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
	
	@OneToOne(mappedBy = "maquinista",cascade = CascadeType.ALL)
	private Locomotiva locomotiva;
	
	public Maquinista() {	
	}

	public Maquinista(Long id, String nome, Integer idade, Double soldo, String email, Locomotiva locomotiva) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.soldo = soldo;
		this.email = email;
		this.locomotiva = locomotiva;
	}

	public String getNome() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
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
	
}
