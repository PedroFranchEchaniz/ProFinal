package com.salesianos.triana.dam.principioProyFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.repos.ProductoRepositorio;

@Service
public class ProductoServicio extends BaseServiceImpl<Producto, Long, ProductoRepositorio>{

	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	public void restarStock (Long id, int cantidad) {
		Producto p = productoRepositorio.findById(id).orElse(null);
		p.setStock(p.getStock()-cantidad);		
	}
	
	public List<Producto> buscarPorTitulo (String titulo){
		return productoRepositorio.buscarPorTitulo(titulo);
		
	}
}
