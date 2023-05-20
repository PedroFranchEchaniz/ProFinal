package com.salesianos.triana.dam.principioProyFinal.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.principioProyFinal.model.Producto;

public interface ProductoRepositorio
	extends JpaRepository<Producto, Long>{
	
	public List<Producto> findByTituloContainingIgnoreCase (String titulo);
	
}
