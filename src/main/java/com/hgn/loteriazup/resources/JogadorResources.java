package com.hgn.loteriazup.resources;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hgn.loteriazup.entities.Jogador;
import com.hgn.loteriazup.services.JogadorService;

@RestController
@RequestMapping(value = "/jogador")
public class JogadorResources {

	@Autowired
	private JogadorService service;

	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public ResponseEntity<Jogador> find(@PathVariable String email) {
		Jogador jogador = service.findByEmail(email);
		return ResponseEntity.ok().body(jogador);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Jogador add(@RequestBody Jogador jogador) {
		jogador.setNome(jogador.getNome());
		jogador.setEmail(jogador.getEmail());
		Set<Integer> apostas = new LinkedHashSet<>();
		for (int i = 1; i <= jogador.getQtdAposta(); i++) {
			Integer aposta = new Random().nextInt(1000);
			apostas.add(aposta);
		}
		jogador.setApostas(apostas);
		return service.save(jogador);
	}
}
