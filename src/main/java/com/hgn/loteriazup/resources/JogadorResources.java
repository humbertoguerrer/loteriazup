package com.hgn.loteriazup.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hgn.loteriazup.entities.Jogador;
import com.hgn.loteriazup.repositories.JogadorRepository;
import com.hgn.loteriazup.services.JogadorService;

@RestController
@RequestMapping(value = "/jogador")
public class JogadorResources {

	@Autowired
	private JogadorService service;

	@Autowired
	private JogadorRepository repository;

	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public Jogador find(@PathVariable String email) {
		Jogador jogador = repository.findByEmail(email);
		return jogador;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Jogador add(@Valid @RequestBody Jogador jogador) {
		return service.save(jogador);

	}
}
