package com.salesianos.triana.dam.principioProyFinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.repos.ProductoRepositorio;

@Service
public class ProductoServicio extends BaseServiceImpl<Producto, Long, ProductoRepositorio> {

	@Autowired
	private ProductoRepositorio productoRepositorio;

	public void restarStock(Long id, int cantidad) {
		Optional<Producto> optionalProducto = productoRepositorio.findById(id);
		Producto producto = optionalProducto.get();
		if (optionalProducto.isPresent()) {
			producto.setStock(producto.getStock() - cantidad);
		}
	}
	
	public List<Producto> findByTitulo (String titulo){
		return productoRepositorio.findByTituloContainingIgnoreCase(titulo);
	}

}
