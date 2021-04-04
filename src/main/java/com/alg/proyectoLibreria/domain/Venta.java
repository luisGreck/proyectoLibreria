package com.alg.proyectoLibreria.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id                                             
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String fecha;

	@Column(name="libro_sucursal_id")
	private int libroSucursalId;

	private double total;

	public Venta() {
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLibroSucursalId() {
		return this.libroSucursalId;
	}

	public void setLibroSucursalId(int libroSucursalId) {
		this.libroSucursalId = libroSucursalId;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}