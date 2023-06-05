package com.salesianos.triana.dam.principioProyFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.principioProyFinal.model.Editorial;
import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.repos.EditorialRepositorio;

@Service
public class EditorialServicio extends BaseServiceImpl<Editorial, Long, EditorialRepositorio> {
	
	@Autowired
	private EditorialRepositorio editorialRepositorio;
	
	/*public int productoEnEditorial (Editorial e) {
		return editorialRepositorio.productoEnEdiotiral(e.getId());
	}*/
}
