package com.alg.proyectoLibreria.service;

import java.util.List;

import com.alg.proyectoLibreria.domain.Libro;

public interface LibroService {
	public List<Libro> buscarLibro(String nombre);
}
