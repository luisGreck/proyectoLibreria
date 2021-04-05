package com.alg.proyectoLibreria.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="libro_sucursal")
public class LibroSucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id                                             
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;

	@Column(name="libro_id")
	private Libro libro;

	@Column(name="sucursal_id")
	private Sucursal sucursal;
	
	private int disponible;
	public LibroSucursal() {
	}

	public int getDisponible() {
		return this.disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
}