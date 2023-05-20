package com.salesianos.triana.dam.principioProyFinal.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.principioProyFinal.model.Producto;

public interface ProductoRepositorio
	extends JpaRepository<Producto, Long>{

	@Query("Select p from producto pr where pr.titulo = ?1")
	public List<Producto> buscarPorTitulo(String titulo);
}
