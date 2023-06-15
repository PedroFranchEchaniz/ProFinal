package com.salesianos.triana.dam.principioProyFinal.model;

import java.util.Set;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Comic extends Producto{

	private String ilustrador;
	private String guionista;
	private String sinopsis;
	
	public Comic(Long id, String titulo, double precioUnidad, int stock, String img, double descuento,
			Editorial editorial, Set<Valoracion> valoraciones, String ilustrador, String guionista, String sinopsis) {
		super(id, titulo, precioUnidad, stock, img, descuento, editorial, valoraciones);
		this.ilustrador = ilustrador;
		this.guionista = guionista;
		this.sinopsis = sinopsis;
	}
	
	
	

	



	
	
	
	
	
}