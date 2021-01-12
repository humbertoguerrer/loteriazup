package com.hgn.loteriazup.entities;

import java.io.Serializable;
import java.util.Random;

public class Aposta implements Serializable {
	private static final long serialVersionUID = 1L;

	private Random numero;

	public Aposta() {
		new Random().nextInt(1000);
	}

	public Random getAposta() {
		return numero;
	}

}
