package com.hgn.loteriazup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hgn.loteriazup.entities.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, String> {

	Jogador findByEmail(String email);

}
