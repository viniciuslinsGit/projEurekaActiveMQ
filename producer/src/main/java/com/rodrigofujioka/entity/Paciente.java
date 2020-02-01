package com.rodrigofujioka.entity;

import java.io.Serializable;

public class Paciente implements Serializable {

	private static final long serialVersionUID = 3230768277726901497L;
	
	private Long id;
	private String nome;
	
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
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + "]";
	}
	
}
