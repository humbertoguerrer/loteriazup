package com.hgn.loteriazup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgn.loteriazup.entities.Jogador;
import com.hgn.loteriazup.repositories.JogadorRepository;
import com.hgn.loteriazup.services.exceptions.ServicesExceptions;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository repository;

	public Jogador findByEmail(String email) {
		return repository.findByEmail(email);
	}

	public Jogador save(Jogador jogador) {
		Jogador jogadorExistente = repository.findByEmail(jogador.getEmail());
		if (jogadorExistente != null && !jogadorExistente.equals(jogador)) {
			throw new ServicesExceptions("Já existe um cliente cadastrado com este e-mail.");
		}

		return repository.save(jogador);

	}
}