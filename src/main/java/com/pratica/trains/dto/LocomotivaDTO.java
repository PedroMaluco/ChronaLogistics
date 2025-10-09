package com.pratica.trains.dto;

import java.util.HashSet;
import java.util.Set;

import com.pratica.trains.entities.Locomotiva;
import com.pratica.trains.entities.Vagao;

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
	@Positive(message = "informe um valor válido")
	private Double kilometragem;
	@Positive(message = "informe um valor válido")
	@Min(value = 1950, message = "Insira um ano à partir de 1950")
	private Integer ano;
	
	private MaquinistaDTO maquinista;
	
	private Set<VagaoDTO>vagoes = new HashSet<>();
	
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
		for (Vagao vag : locomotiva.getVagoes()) {
			addVagao(new VagaoDTO(vag));
		}
		vagoes = getVagoes();
		maquinista = new MaquinistaDTO(locomotiva.getMaquinista());	
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

	public MaquinistaDTO getMaquinista() {
		return maquinista;
	}

	public void setMaquinista(MaquinistaDTO maquinista) {
		this.maquinista = maquinista;
	}
	
	public void addVagao(VagaoDTO vagao) {
		vagoes.add(vagao);
	}

	public Set<VagaoDTO> getVagoes() {
		return vagoes;
	}
	
	
}
