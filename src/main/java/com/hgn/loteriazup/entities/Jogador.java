package com.hgn.loteriazup.entities;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Jogador implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;

	@Id
	@Column(unique = true)
	private String email;

	private Integer qtdAposta;

	@ElementCollection
	@CollectionTable(name = "email_apostas")
	private Set<Integer> apostas = new LinkedHashSet<>();

	public Jogador() {

	}

	public Jogador(String nome, String email) {
		this.nome = nome;
		this.email = email;

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

	public Integer getQtdAposta() {
		return qtdAposta;
	}

	public void setQtdAposta(Integer qtdAposta) {
		this.qtdAposta = qtdAposta;
	}

	public Set<Integer> getApostas() {
		return apostas;
	}

	public void setApostas(Set<Integer> apostas) {
		this.apostas = apostas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}
