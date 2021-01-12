package com.hgn.loteriazup.resources;

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
		Jogador obj = service.findByEmail(email);
		return ResponseEntity.ok().body(obj);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Jogador adicionar(@RequestBody Jogador jogador) {
		return service.save(jogador);
	}

}
