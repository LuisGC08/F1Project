package com.bolsadeideas.springboot.backend.apirest.models.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Piloto;


/*
 * Muestro los datos del apirest
 * 
 */

public interface PilotoDaiIntefaz {
	public ArrayList<Piloto> findAll();

	public Piloto getdriver(String id);

	public ArrayList<Piloto> getraces(String id);
}