package com.hgn.loteriazup.services;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgn.loteriazup.entities.Jogador;
import com.hgn.loteriazup.repositories.JogadorRepository;
import com.hgn.loteriazup.services.exceptions.ServicesExceptions;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository repository;

	public Jogador save(Jogador jogador) {
		Jogador jogadorExistente = repository.findByEmail(jogador.getEmail());
		if (jogadorExistente != null && jogadorExistente.getEmail().equals(jogador.getEmail())) {
			throw new ServicesExceptions("Já existe um jogador cadastrado com este e-mail.");
		} else {
			Set<Integer> apostas = new LinkedHashSet<>();
			for (int i = 0; i <= jogador.getQtdAposta(); i++) {
				Integer aposta = new Random().nextInt(1000);
				apostas.add(aposta);
			}

			jogador.setApostas(apostas);
			return repository.save(jogador);

		}
	}
}
