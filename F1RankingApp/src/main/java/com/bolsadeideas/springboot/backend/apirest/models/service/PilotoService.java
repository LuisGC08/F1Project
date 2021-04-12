package com.bolsadeideas.springboot.backend.apirest.models.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.backend.apirest.models.dao.PilotoDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Piloto;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Carrera;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PilotoService implements PilotoServiceInterfaz {
/*
 * Obtengo los datos del pilotoDAo
 */
	@Autowired
	private PilotoDao driverDao;

	@Override
	public ArrayList<Piloto> findAll() {
		return driverDao.findAll();
	}

	@Override
	public Piloto getdriver(String id) {
		return driverDao.getdriver(id);

	}

	@Override
	public ArrayList<Piloto> getraces(String id) {
		return driverDao.getraces(id);

	}
}
