package com.pratica.trains.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_maquinista")
public class Maquinista implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer idade;
	private Double soldo;
	private String email;
	private String senha;
	
	@ManyToMany
	@JoinTable(name = "tb_maquinista_role", 
		joinColumns = @JoinColumn(name="maquinista_id"), 
		inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return nome;
	}
	
	public void addRole(Role role) {
		roles.add(role);
	}
	
	public boolean hasRole(String roleName) {
		for(Role role : roles) {
			if(role.getAuthority().equals(roleName)){
				return true;
			}
		}
			return false;
		
	}
	
}
