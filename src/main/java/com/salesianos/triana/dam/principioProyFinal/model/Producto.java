package com.salesianos.triana.dam.principioProyFinal.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_producto_comit"))
	private Editorial editorial;
	
	public void addToEditorial(Editorial editorial) {
		this.editorial=editorial;
		editorial.getProductos().add(this);
	}
	
	public void removeFromEditorial(Editorial editorial) {
		editorial.getProductos().remove(this);
		this.editorial = null;
	}
}
