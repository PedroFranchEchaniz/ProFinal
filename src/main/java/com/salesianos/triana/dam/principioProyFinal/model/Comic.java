package com.salesianos.triana.dam.principioProyFinal.model;

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
	
	public Comic(Long id, String titulo, double precioUnidad, int stock, String img, Editorial editorial,
			String ilustrador, String guionista, String sinopsis) {
		super(id, titulo, precioUnidad, stock, img, editorial);
		this.ilustrador = ilustrador;
		this.guionista = guionista;
		this.sinopsis = sinopsis;
	}


<<<<<<< HEAD
=======
	
	
	
>>>>>>> fixes
	
	
	
	
	
	
}