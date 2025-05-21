package com.pratica.trains.dto;

import com.pratica.trains.entities.Locomotiva;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class LocomotivaDTO {
	
	private Long id;
	
	@NotBlank(message = "O nome da locomotiva não pode ser nulo")
	@Size(min = 3, max = 30, message = "Escolha um tamanho adequado de nome")
	private String nome;
	@NotBlank(message = "O modelo deve ser especificado")
	private String modelo;
	@Positive(message = "Valor inválido")
	private Double kilometragem;
	@Positive(message = "Ano inválido")
	@Min(value = 1950, message = "Insira um ano à partir de 1950")
	private Integer ano;
	
	public LocomotivaDTO() {
	}

	public LocomotivaDTO(Long id, String nome, String modelo, Double kilometragem, Integer ano) {
		this.id = id;
		this.nome = nome;
		this.modelo = modelo;
		this.kilometragem = kilometragem;
		this.ano = ano;
	}
	
	public LocomotivaDTO(Locomotiva locomotiva) {
		id = locomotiva.getId();
		nome = locomotiva.getNome();
		modelo = locomotiva.getModelo();
		kilometragem = locomotiva.getKilometragem();
		ano = locomotiva.getAno();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getModelo() {
		return modelo;
	}

	public Double getKilometragem() {
		return kilometragem;
	}

	public Integer getAno() {
		return ano;
	}
}
