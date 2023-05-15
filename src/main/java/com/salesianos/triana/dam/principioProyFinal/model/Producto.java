package com.salesianos.triana.dam.principioProyFinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class Producto {
	@Id
	@GeneratedValue
	protected Long id;
	protected String titulo;
	protected double precioUnidad;
	protected int stock;	

	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_producto_editorial"))
	protected Editorial editorial;	
	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="producto", fetch = FetchType.EAGER)
	@Builder.Default
	protected List<Valoracion> valoraciones = new ArrayList<>();
	
	
	public void addToEditorial(Editorial editorial) {
		this.editorial=editorial;
		editorial.getProductos().add(this);
	}
	
	public void removeFromEditorial(Editorial editorial) {
		editorial.getProductos().remove(this);
		this.editorial = null;
	}	
	

	public Producto(Long id, String titulo, double precioUnidad, int stock, Editorial editorial) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precioUnidad = precioUnidad;
		this.stock = stock;
		this.editorial = editorial;		
	}
	
}
