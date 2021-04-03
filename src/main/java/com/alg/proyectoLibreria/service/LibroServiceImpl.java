package com.alg.proyectoLibreria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alg.proyectoLibreria.domain.Libro;
import com.alg.proyectoLibreria.repository.LibroRepository;

public class LibroServiceImpl implements LibroService {
	
	@Autowired
	LibroRepository libroRepository;

	@Override
	public List<Libro> buscarLibro(String nombre) {
		return libroRepository.buscar(nombre);
	}

}
