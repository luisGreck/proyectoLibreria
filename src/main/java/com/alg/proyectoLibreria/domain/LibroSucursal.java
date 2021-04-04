package com.alg.proyectoLibreria.domain;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="libro_sucursal")
@NamedQuery(name="LibroSucursal.findAll", query="SELECT l FROM LibroSucursal l")
public class LibroSucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	private int disponible;
	@Id                                             
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;

	@Column(name="libro_id")
	private int libroId;

	@Column(name="sucursal_id")
	private int sucursalId;

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

	public int getLibroId() {
		return this.libroId;
	}

	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}

	public int getSucursalId() {
		return this.sucursalId;
	}

	public void setSucursalId(int sucursalId) {
		this.sucursalId = sucursalId;
	}

}