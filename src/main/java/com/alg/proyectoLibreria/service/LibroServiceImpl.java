package com.alg.proyectoLibreria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alg.proyectoLibreria.domain.Libro;
import com.alg.proyectoLibreria.repository.LibroRepository;


@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	LibroRepository libroRepository;

	@Override
	public List<Libro> buscarLibro(String nombre) {
		return libroRepository.buscar(nombre);
	}

	@Override
	public List<Libro> obtenerLibros() {
		return libroRepository.findAll();
	}

}
