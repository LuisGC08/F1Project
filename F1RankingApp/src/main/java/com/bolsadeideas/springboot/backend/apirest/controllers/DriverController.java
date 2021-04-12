package com.bolsadeideas.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Piloto;
import com.bolsadeideas.springboot.backend.apirest.models.service.PilotoServiceInterfaz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DriverController {
	/*
	 * Llamo a la interfaz IdriverService, que tiene los datos del driverService
	 * y así recibo los datos obtenidos en el api rest
	 */
	@Autowired
	private PilotoServiceInterfaz driverService;

	/*
	 * Muestro a los pilotos y los devuelve en formati json, mediante el metodo gson,
	 * obtenido previamente por la libreria gson
	 */
	@GetMapping("/ranking")
public String listar() {
		Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
		
		
return gson.toJson(driverService.findAll());

	}

	/*
	 * Método que muestra un piloto concreto obteniendolor por el id
	 */

	@RequestMapping(value = "/driver", params = "id")
	public Piloto getid(@RequestParam String id) {
		//este método hace que cuando se recargue la página, no se pierdan los datos,
		//similar al localStorage
		driverService.findAll();
		
		
		return driverService.getdriver(id);
	}

	/*
	 * metodo que muestra en una carrera en concreto a todos los pilotos
	 * 
	 */
	@RequestMapping(value = "/ranking", params = "id")
	public String getraceid(@RequestParam String id) {
		
		
	Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
		driverService.findAll();
		
		return gson.toJson(driverService.getraces(id));
	}
}
