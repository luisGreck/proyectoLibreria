package com.alg.proyectoLibreria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alg.proyectoLibreria.domain.Venta;
import com.alg.proyectoLibreria.repository.VentaRepository;


@Service
public class VentaServiceImpl implements VentaService {
	
	@Autowired
	VentaRepository ventaRepository;

	@Override
	public boolean vender(Venta venta) {
		boolean b=false;
		Venta v = ventaRepository.save(venta);
		if(v != null && v.getId()>0) {
			b=true;
		}
		return b;
	}

}
