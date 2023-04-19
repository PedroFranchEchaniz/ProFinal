package com.salesianos.triana.dam.principioProyFinal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianos.triana.dam.principioProyFinal.model.Editorial;
import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.repos.EditorialRepositorio;
import com.salesianos.triana.dam.principioProyFinal.repos.ProductoRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

	@Autowired
	private final ProductoRepositorio productorepositorio;
	private final EditorialRepositorio editorialrepositorio;
	
	@PostConstruct
	public void ejecutar() {
		
		Producto p1 = new Producto();
		p1.setTitulo("Batman Luces de Neón");
		p1.setPrecioUnidad(12.50);
		p1.setStock(3);
		
		Producto p2 = new Producto();
		p2.setTitulo("Hellboy Vol.2");
		p2.setPrecioUnidad(20);
		p2.setStock(2);
		
		Editorial e1 = new Editorial();
		e1.setNombre("Norma");
		e1.setContacto("normal@gmail.com");
		e1.setDireccion("C/ Lazaro s/n Madrid (Madrid) 49001");
		editorialrepositorio.save(e1);
		
		p1.addToEditorial(e1);
		p2.addToEditorial(e1);
		
		productorepositorio.save(p1);
		productorepositorio.save(p2);
		
		System.out.println(e1);
		for(Producto p : e1.getProductos()) {
			System.out.println(p);
		}
	}
}
