package com.salesianos.triana.dam.principioProyFinal.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianos.triana.dam.principioProyFinal.model.Editorial;

@Repository
public interface EditorialRepositorio
	extends JpaRepository<Editorial, Long>{	
	
}
