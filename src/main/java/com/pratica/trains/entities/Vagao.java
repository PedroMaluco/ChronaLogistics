package com.pratica.trains.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_vagoes")
public class Vagao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double peso;
	private Integer ano;
	
	private ModeloVagao modelo;
	
	@ManyToOne
	@JoinColumn(name = "locomotiva_id")
	private Locomotiva locomotiva; 
	
	public Vagao() {
	}

	public Vagao(Long id, Double peso, Integer ano, ModeloVagao modelo, Locomotiva locomotiva) {
		this.id = id;
		this.peso = peso;
		this.ano = ano;
		this.modelo = modelo;
		this.locomotiva = locomotiva;
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

	public Locomotiva getLocomotiva() {
		return locomotiva;
	}

	public void setLocomotiva(Locomotiva locomotiva) {
		this.locomotiva = locomotiva;
	}
}
