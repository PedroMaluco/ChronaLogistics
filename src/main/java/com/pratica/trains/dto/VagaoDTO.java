package com.pratica.trains.dto;

import com.pratica.trains.entities.ModeloVagao;
import com.pratica.trains.entities.Vagao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VagaoDTO {
	
	private Long id;
	@NotNull(message = "Informe o peso do vagão")
	@Positive(message = "informe um valor válido")
	private Double peso;
	@NotNull(message = "Informe o ano de produção do vagão")
	@Positive(message = "informe um valor válido")
	private Integer ano;
	private ModeloVagao modelo;
	
	public VagaoDTO() {
	}

	public VagaoDTO(Long id, Double peso, Integer ano, ModeloVagao modelo) {
		this.id = id;
		this.peso = peso;
		this.ano = ano;
		this.modelo = modelo;
	}

	public VagaoDTO(Vagao entity) {
		id = entity.getId();
		peso = entity.getPeso();
		ano = entity.getAno();
		modelo = entity.getModelo();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public ModeloVagao getModelo() {
		return modelo;
	}


	public void setModelo(ModeloVagao modelo) {
		this.modelo = modelo;
	}
}
