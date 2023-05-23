package com.salesianos.triana.dam.principioProyFinal.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianos.triana.dam.principioProyFinal.model.JuegoMesa;

public interface JmesaRepositorio extends JpaRepository <JuegoMesa, Long> {
	public List<JuegoMesa> findByTituloContainsIgnoreCase (String titulo);
}
