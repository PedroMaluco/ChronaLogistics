package com.pratica.trains.dto;

import com.pratica.trains.entities.Maquinista;

public class MaquinistaDTO {
	
	private Long id;
	private String nome;
	private Integer idade;
	private Double soldo;
	private String email;
	
	public MaquinistaDTO() {
	}

	public MaquinistaDTO(Long id, String nome, Integer idade, Double soldo, String email) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.soldo = soldo;
		this.email = email;
	}
	
	public MaquinistaDTO(Maquinista maquinista) {
		id = maquinista.getId();
		nome = maquinista.getNome();
		idade = maquinista.getIdade();
		soldo = maquinista.getSoldo();
		email = maquinista.getEmail();
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
}
