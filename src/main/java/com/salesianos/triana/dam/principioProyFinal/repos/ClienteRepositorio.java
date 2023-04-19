package com.salesianos.triana.dam.principioProyFinal.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;

public interface ClienteRepositorio
	extends JpaRepository <Cliente, Long>{

}
