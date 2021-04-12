package com.bolsadeideas.springboot.backend.apirest.models.service;

import java.util.ArrayList;
import java.util.List;


/*
 * Obtengo los datos en la interfaz
 */
import com.bolsadeideas.springboot.backend.apirest.models.entity.Piloto;

public interface PilotoServiceInterfaz {
	public ArrayList<Piloto> findAll();

	public Piloto getdriver(String id);

	public ArrayList<Piloto> getraces(String id);
}
