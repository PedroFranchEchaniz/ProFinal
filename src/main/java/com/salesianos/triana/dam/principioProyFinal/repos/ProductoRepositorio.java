package com.salesianos.triana.dam.principioProyFinal.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salesianos.triana.dam.principioProyFinal.model.Editorial;
import com.salesianos.triana.dam.principioProyFinal.model.Producto;

@Repository
public interface ProductoRepositorio
	extends JpaRepository<Producto, Long>{
	
	public List<Producto> findByTituloContainingIgnoreCase (String titulo);
	
	
	
}
