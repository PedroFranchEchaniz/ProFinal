package com.salesianos.triana.dam.principioProyFinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.principioProyFinal.model.JuegoMesa;
import com.salesianos.triana.dam.principioProyFinal.repos.JmesaRepositorio;

@Service
public class JmesaServicio extends BaseServiceImpl <JuegoMesa, Long, JmesaRepositorio>{

	public List<JuegoMesa> findByTitulo (String titulo){
		return this.repository.findByTituloContainsIgnoreCase(titulo);
	}
}
