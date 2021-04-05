package com.alg.proyectoLibreria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alg.proyectoLibreria.domain.Libro;
import com.alg.proyectoLibreria.domain.Venta;
import com.alg.proyectoLibreria.service.LibroService;

@Controller 
public class LiberiaController {
	 @Autowired
	 LibroService libroService;
	
    @RequestMapping("/")
    public String principal(Model model){
        return "principal";
    }  
    
    @RequestMapping("/vender")
    public String venta(Model model){
    	List<Libro> libros=libroService.obtenerLibros();
        model.addAttribute("libro", new Libro());
        model.addAttribute("venta", new Venta());
        model.addAttribute("libros", libros);
        return "venta";
    }  
    
    @RequestMapping("/existencia")
    public String existencia(Model model){
        return "existencia";
    }  

}
