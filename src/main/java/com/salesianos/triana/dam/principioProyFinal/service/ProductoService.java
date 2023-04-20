package com.salesianos.triana.dam.principioProyFinal.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.principioProyFinal.model.Producto;

@Service
public class ProductoService {	
	 
	public List<Producto> getLista() {
		return Arrays.asList(
				new Producto(1L,"Batman Luces de Neón", 12.50,3),
				new Producto (2L,"Hellboy Vol.2", 12.50,3),
				new Producto (3L, "Torpedo Integral", 30, 4)
				);		
	}
}
