package com.alg.proyectoLibreria.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l")
public class Libro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id                                             
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String autor;
	private String nombre;
	private double precio;

	public Libro() {
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
