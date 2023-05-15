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
public class JuegoMesa extends Producto{

	private int nJugadores;
	private String tipo;
	private String descripcion;	
	

	public JuegoMesa(Long id, String titulo, double precioUnidad, int stock, Editorial editorial, int nJugadores,
			String tipo, String descripcion) {
		super(id, titulo, precioUnidad, stock, editorial);
		this.nJugadores = nJugadores;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	
	
	
}
