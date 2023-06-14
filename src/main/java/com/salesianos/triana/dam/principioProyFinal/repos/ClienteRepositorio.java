package com.salesianos.triana.dam.principioProyFinal.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;

@Repository
public interface ClienteRepositorio
	extends JpaRepository <Cliente, Long>{

	Optional<Cliente> findFirstByUsername(String username);

	public List<Cliente> findByNombreContainsIgnoreCase(String nombre);
}
