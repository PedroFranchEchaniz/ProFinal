package com.salesianos.triana.dam.principioProyFinal.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianos.triana.dam.principioProyFinal.model.Producto;

@Repository
public interface ProductoRepositorio
	extends JpaRepository<Producto, Long>{
	
	public List<Producto> findByTituloContainingIgnoreCase (String titulo);	
	
	@Query("SELECT p FROM Producto p JOIN Comic c ON p.id = c.id")
	public List<Producto> comics();
	
	@Query("SELECT p FROM Producto p JOIN JuegoMesa j ON p.id = j.id")
	public List<Producto> juegosMesa();
	
	@Query ("SELECT p FROM Producto p JOIN Comic c ON p.id = c.id WHERE p.descuento > 0")
	public List<Producto> comicsDescuento();

	@Query ("SELECT p FROM Producto p JOIN JuegoMesa j ON p.id = j.id WHERE p.descuento > 0")
	public List<Producto> JuegosDescuento();
	
	@Query("SELECT p FROM Producto p WHERE p.descuento > 0")
	public List<Producto> productosDescuento();
	
	@Query("SELECT p FROM Producto p WHERE p.precioUnidad BETWEEN 1? AND 2?")
	public List<Producto> filtrarPrecio();
}
