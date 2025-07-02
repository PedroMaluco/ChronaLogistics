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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_locomotiva")
public class Locomotiva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String modelo;
	private Double kilometragem;
	private Integer ano;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Maquinista maquinista;
	
	@OneToMany(mappedBy = "locomotiva", cascade = CascadeType.ALL)
	private Set<Vagoes>vagoes = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "itinerario_id")
	private Itinerario itinerario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_locomotiva_estacao", 
	joinColumns = @JoinColumn(name = "locomotiva_id"), 
	inverseJoinColumns = @JoinColumn(name = "estacao_id"))
	private Estacao estacao;

	public Locomotiva() {
	}

	public Locomotiva(Long id, String nome, String modelo, Double kilometragem, Integer ano,
			Set<Vagoes> vagoes, Itinerario itinerario, Estacao estaçao) {
		this.id = id;
		this.nome = nome;
		this.modelo = modelo;
		this.kilometragem = kilometragem;
		this.ano = ano;
		this.vagoes = vagoes;
		this.itinerario = itinerario;
		this.estacao = estacao;
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(Double kilometragem) {
		this.kilometragem = kilometragem;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Maquinista getMaquinista() {
		return maquinista;
	}

	public void setMaquinista(Maquinista maquinista) {
		this.maquinista = maquinista;
	}

	public Set<Vagoes> getVagoes() {
		return vagoes;
	}

	public Itinerario getItinerario() {
		return itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	public Estacao getEstacao() {
		return estacao;
	}

	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}
	
	
	
	
	
}
