package com.salesianos.triana.dam.principioProyFinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	@JoinColumn(foreignKey = @ForeignKey(name="fk_producto_editorial"))
	private Editorial editorial;	
	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="producto", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Valoracion> valoraciones = new ArrayList<>();
	
	
	public void addToEditorial(Editorial editorial) {
		this.editorial=editorial;
		editorial.getProductos().add(this);
	}
	
	public void removeFromEditorial(Editorial editorial) {
		editorial.getProductos().remove(this);
		this.editorial = null;
	}
	
	public Producto(Long id, String titulo, double precioUnidad, int stock) {
		this.id = id;
		this.titulo = titulo;
		this.precioUnidad = precioUnidad;
		this.stock = stock;
	}
	
}
