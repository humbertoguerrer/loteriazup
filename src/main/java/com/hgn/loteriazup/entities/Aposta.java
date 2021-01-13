/* package com.hgn.loteriazup.entities;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aposta {



	private Jogador jogador;
	@Id
	@ManyToOne
	@JoinColumn(name = "jogador_email")
	private String jogadorEmail;
	private Integer numero;

	public Aposta() {

	}

	public Aposta(String jogadorEmail, Integer numero) {
		super();
		this.jogadorEmail = jogador.getEmail();
		this.numero = numero;
	}

	public String getJogadorEmail() {
		return jogadorEmail;
	}

	public void setJogadorEmail(String jogadorEmail) {
		this.jogadorEmail = jogador.getEmail();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = new Random().nextInt(100);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Aposta other = (Aposta) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

} */
