package com.salesianos.triana.dam.principioProyFinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.principioProyFinal.model.Comic;
import com.salesianos.triana.dam.principioProyFinal.repos.ComicRepositorio;

@Service
public class ComicServicio extends BaseServiceImpl<Comic, Long, ComicRepositorio>{
	
	public List<Comic> findByNombre(String titulo){
		return this.repository.findByTituloContainsIgnoreCase(titulo);
	}

}
