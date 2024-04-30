package com.Mario_Gago.gestioPaissos.backend.business.model;

import java.io.Serializable;

public class Pais implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	String nombre, moneda;
	private int area, numHabitantes;
	
	public Pais() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getNumHabitantes() {
		return numHabitantes;
	}

	public void setNumHabitantes(int numHabitantes) {
		this.numHabitantes = numHabitantes;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	
}
