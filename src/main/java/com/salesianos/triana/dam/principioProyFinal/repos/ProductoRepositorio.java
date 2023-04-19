package com.salesianos.triana.dam.principioProyFinal.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianos.triana.dam.principioProyFinal.model.Producto;

public interface ProductoRepositorio
	extends JpaRepository<Producto, Long>{

}
