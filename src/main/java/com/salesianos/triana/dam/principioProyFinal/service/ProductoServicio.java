package com.salesianos.triana.dam.principioProyFinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.repos.ProductoRepositorio;

@Service
public class ProductoServicio extends BaseServiceImpl<Producto, Long, ProductoRepositorio> {

	

	public void restarStock(Long id, int cantidad) {
		Optional<Producto> optionalProducto = this.repository.findById(id);
		Producto producto = optionalProducto.get();
		if (optionalProducto.isPresent()) {
			producto.setStock(producto.getStock() - cantidad);
		}
	}
	
	public List<Producto> findByTitulo (String titulo){
		return this.repository.findByTituloContainingIgnoreCase(titulo);
	}
	
	public List<Producto> listaComics (){
		return this.repository.comics();
	}
	
	public List<Producto> listaJuegosMesa(){
		return this.repository.juegosMesa();
	}
	
	public List<Producto> listaComicsDescuento(){
		return this.repository.comicsDescuento();
	}
	
	public List<Producto> listaJuegosDescuento(){
		return this.repository.JuegosDescuento();		
	}
	
	public List<Producto> filtroPrecioMinMax(double min, double max){
		return this.repository.filtrarPrecio(min, max);
	}
	
	

}
