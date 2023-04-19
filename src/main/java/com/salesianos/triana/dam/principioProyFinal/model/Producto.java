package com.salesianos.triana.dam.principioProyFinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
	@Id
	@GeneratedValue
	private Long id;
	private String titulo;
	private double precioUnidad;
	private int stock;
	
}
