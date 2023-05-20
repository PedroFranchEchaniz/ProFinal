package com.salesianos.triana.dam.principioProyFinal.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;
import com.salesianos.triana.dam.principioProyFinal.model.Venta;

public interface VentaRepositorio extends JpaRepository<Venta, Long> {

		@Query("Select v from Venta v where cliente_id = ?1")
		public List<Venta> buscarPorIdCliente (Long id);
	
}
