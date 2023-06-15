package com.salesianos.triana.dam.principioProyFinal.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianos.triana.dam.principioProyFinal.model.Valoracion;
import com.salesianos.triana.dam.principioProyFinal.model.ValoracionPk;

@Repository
public interface ValoracionRepositorio
	extends JpaRepository <Valoracion, ValoracionPk>{
	
	@Query("SELECT v FROM Valoracion v JOIN Producto p WHERE p.id = ?1")
	public List<Valoracion> valoraciones (Long id);
}
