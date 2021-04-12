package com.bolsadeideas.springboot.backend.apirest.models.dao;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
//import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Carrera;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Piloto;


import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


@Repository
public class PilotoDao implements PilotoDaiIntefaz {
	
	//tengo a todos los pilotos en un arrayList
	private ArrayList<Piloto> drivers;


	public PilotoDao(ArrayList<Piloto> drivers) {
		this.drivers = drivers;
	}

	/*
	 * Muestro los datos del json metiendolos en un array list mediante una pojo
	 * y muestro los datos ordenados
	 */

	@Override
	public ArrayList<Piloto> findAll() {

		drivers.clear();

		try (Reader reader = new FileReader(
				"C:\\BpE\\ws-java-basic\\F1RankingApp\\src\\main\\resources\\json\\data.json")) {
			List<Piloto> driver = new Gson().fromJson(reader, new TypeToken<List<Piloto>>() {
			}.getType());
			
			//
			for (Piloto driver2 : driver) {
				drivers.add(driver2);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//
			
			e.printStackTrace();
		}

		Collections.sort(drivers, new Piloto());

		int posicion = 1;
//recorro el bucle for de los pilotos
		for (Piloto driver : drivers) {
			
			driver.setPosglobal(posicion);
			posicion++;
		}

		return drivers;
	}

	/*
	 * Muestro un piloto en concreto obteniendolo por su id
	 */

	@Override
	public Piloto getdriver(String id) {
		Piloto d = null;

		for (Piloto driver2 : drivers) {
			//si la id que recibe es igual, entonces existe ese piloto
			if (driver2.getId().equals(id)) {
				d = driver2;
			}

		}
		/*
		 * Cojo todas las carrerars y las pongo en un array list
		 * 
		 */
		ArrayList<Carrera> races = (ArrayList<Carrera>) d.getRaces();
		String iddriv = d.getId();
		for (Carrera race : races) {
//obtengo el nombre de la carrera
			String racename = race.getName();
			
			//cojo los pilotos en un array list
			ArrayList<Piloto> driverforrace = getraces(race.getName());
			/*
			 * TEngo a los pilotos y los busco en la carrera para poder obtener sus posiciones
			 * y ordenarlas
			 */
			for (Piloto driverfor : driverforrace) {
				
				if (driverfor.getId().equals(iddriv)) {
					
					ArrayList<Carrera> racesdriv = (ArrayList<Carrera>) driverfor.getRaces();
					race.setPos(racesdriv.get(0).getPos());
					
					
					break;

				}
			}

		}

		return d;

	}

	/*
	 * Muestro los pilotos que hay en una sola carrera
	 * con los datos ordenados
	 */
	@Override
	public ArrayList<Piloto> getraces(String id) {

		ArrayList<Piloto> diverinRace = new ArrayList<Piloto>();

		for (Piloto driverid : drivers) {
			ArrayList<Carrera> idrace = new ArrayList<Carrera>();

			ArrayList<Carrera> races = (ArrayList<Carrera>) driverid.getRaces();

			for (Carrera race : races) {

				if (race.getName().equals(id)) {
					
					
					Piloto driv = new Piloto(driverid);
					idrace.add(race);
					driv.setRaces(idrace);
					diverinRace.add(driv);
					
					
					break;
				}
			}

		}

		Collections.sort(diverinRace, new Piloto());

		int pos = 1;
		
		for (Piloto driverfor : diverinRace) {
			
			driverfor.getRaces().get(0).setPos(pos);
			pos++;
		}

		return diverinRace;
	}

}
