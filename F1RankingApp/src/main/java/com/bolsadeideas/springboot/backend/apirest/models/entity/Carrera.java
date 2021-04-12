package com.bolsadeideas.springboot.backend.apirest.models.entity;

import com.google.gson.annotations.Expose;

public class Carrera {

	@Expose(serialize = true)
	private String name;
	private String time;
	private int pos;

	public Carrera() {

	}

	public Carrera(String name, String time) {
		this.name = name;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
}
