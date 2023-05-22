package com.salesianos.triana.dam.principioProyFinal.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianos.triana.dam.principioProyFinal.model.Comic;

@Repository
public interface ComicRepositorio extends JpaRepository <Comic, Long> {

	public List<Comic> findByTituloContainsIgnoreCase(String titulo);
	
}
