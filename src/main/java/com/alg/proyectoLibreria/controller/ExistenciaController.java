package com.alg.proyectoLibreria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.alg.proyectoLibreria.domain.Libro;
import com.alg.proyectoLibreria.service.LibroService;

@Controller
public class ExistenciaController {
	
	@Autowired
    private  LibroService libroService;
	
	@GetMapping(value = "libro/{nombre}",produces = MediaType.APPLICATION_JSON_VALUE)
	List<Libro> verificarExistencia(@PathVariable("nombre") String nombre){
		return libroService.buscarLibro(nombre);
	}

}
