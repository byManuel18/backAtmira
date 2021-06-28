package com.example.backend.models;

import java.sql.Date;

public class Asteroide {
	private String nombre;
	private double diametro;
	private double velocidad;
	private String fecha;
	private String planeta;
	
	public Asteroide() {
		
	}
	public Asteroide(String nombre, double diametro, double velocidad, String fecha, String planeta) {
		super();
		this.nombre = nombre;
		this.diametro = diametro;
		this.velocidad = velocidad;
		this.fecha = fecha;
		this.planeta = planeta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getDiametro() {
		return diametro;
	}
	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getPlaneta() {
		return planeta;
	}
	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}
	@Override
	public String toString() {
		return "Asteroide [nombre=" + nombre + ", diametro=" + diametro + ", velocidad=" + velocidad + ", fecha="
				+ fecha + ", planeta=" + planeta + "]";
	}
	
	
	
	
}
