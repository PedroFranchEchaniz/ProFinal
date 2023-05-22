package com.salesianos.triana.dam.principioProyFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.principioProyFinal.model.Comic;
import com.salesianos.triana.dam.principioProyFinal.repos.ComicRepositorio;

@Service
public class ComicServicio extends BaseServiceImpl<Comic, Long, ComicRepositorio>{
	
	@Autowired
	private ComicRepositorio comicRepositorio;
	
	public List<Comic> findByNombre(String titulo){
		return comicRepositorio.findByTituloContainsIgnoreCase(titulo);
	}

}