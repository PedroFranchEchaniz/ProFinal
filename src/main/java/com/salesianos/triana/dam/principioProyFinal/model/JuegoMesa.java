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
public class JuegoMesa extends Producto{

	private int nJugadoresMin;
	private int nJugadoresMax;
	private String tipo;
	private String descripcion;
	
	public JuegoMesa(Long id, String titulo, double precioUnidad, int stock, String img, double descuento,
			Editorial editorial, Set<Valoracion> valoraciones, int nJugadoresMin, int nJugadoresMax, String tipo,
			String descripcion) {
		super(id, titulo, precioUnidad, stock, img, descuento, editorial, valoraciones);
		this.nJugadoresMin = nJugadoresMin;
		this.nJugadoresMax = nJugadoresMax;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}	

	
	
}
