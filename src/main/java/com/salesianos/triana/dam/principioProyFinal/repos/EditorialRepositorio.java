package com.salesianos.triana.dam.principioProyFinal.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.principioProyFinal.model.Editorial;

public interface EditorialRepositorio
	extends JpaRepository<Editorial, Long>{
	
	/*@Query ("SELECT COUNT (productos.id) FROM editorial WHERE id = 1?")
	public int productoEnEdiotiral (Long id);*/
}
