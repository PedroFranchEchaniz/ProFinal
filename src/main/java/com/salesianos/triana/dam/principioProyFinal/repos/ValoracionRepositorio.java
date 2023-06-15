package com.salesianos.triana.dam.principioProyFinal.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianos.triana.dam.principioProyFinal.model.Valoracion;
import com.salesianos.triana.dam.principioProyFinal.model.ValoracionPk;


public interface ValoracionRepositorio
	extends JpaRepository <Valoracion, ValoracionPk>{

}
