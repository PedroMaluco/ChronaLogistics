package com.pratica.trains.dto;

public class RegisterDTO {
	
	private String nome;
	private String email;
	private Integer idade;
	private String senha;
	
	public RegisterDTO(String nome, String email, Integer idade, String senha) {
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
