package com.salesianos.triana.dam.principioProyFinal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;
import com.salesianos.triana.dam.principioProyFinal.model.Editorial;
import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.model.Valoracion;
import com.salesianos.triana.dam.principioProyFinal.repos.ClienteRepositorio;
import com.salesianos.triana.dam.principioProyFinal.repos.EditorialRepositorio;
import com.salesianos.triana.dam.principioProyFinal.repos.ProductoRepositorio;
import com.salesianos.triana.dam.principioProyFinal.repos.ValoracionRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

	@Autowired
	private final ProductoRepositorio productorepositorio;
	private final EditorialRepositorio editorialrepositorio;
	private final ClienteRepositorio clienterepositorio;
	private final ValoracionRepositorio valoracionrepositorio;
	
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
		
		Cliente c1 = new Cliente();
		c1.setNombre("Pedro");
		c1.setApellidos("Franch Echániz");
		c1.setNombreUsuario("PedroFeAv");
		c1.setContrasenia("1234");
		clienterepositorio.save(c1);
		
		Valoracion v1 = new Valoracion();
		v1.setPuntuacion(2);
		v1.setComentario("Un cómic genial");
		valoracionrepositorio.save(v1);
		
		v1.addToCliente(c1);
		v1.addToProducto(p1);
		
		p1.addToEditorial(e1);		
		p2.addToEditorial(e1);
		
		productorepositorio.save(p1);
		productorepositorio.save(p2);
		
		System.out.println(e1);
		for(Producto p : e1.getProductos()) {
			System.out.println(p);
		
		for(Valoracion v : p1.getValoraciones()) {
			System.out.println(v);
		}
		}
	}
}
