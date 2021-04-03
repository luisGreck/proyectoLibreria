package com.alg.proyectoLibreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alg.proyectoLibreria.domain.Venta;
import com.alg.proyectoLibreria.service.VentaService;

@Controller
public class VentaController {
	
	@Autowired
	VentaService ventaService;
	
	@PostMapping(value = "venta",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	boolean venderLibro(@RequestBody Venta venta){
		return ventaService.vender(venta);
	}

}
