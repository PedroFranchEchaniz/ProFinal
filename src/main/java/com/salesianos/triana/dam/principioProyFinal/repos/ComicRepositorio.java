package com.salesianos.triana.dam.principioProyFinal.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianos.triana.dam.principioProyFinal.model.Comic;

public interface ComicRepositorio extends JpaRepository <Comic, Long> {

	List<Comic> findByTituloContainsIgnoreCase(String titulo);
	
}
