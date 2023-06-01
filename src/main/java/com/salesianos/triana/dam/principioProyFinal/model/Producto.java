package com.salesianos.triana.dam.principioProyFinal.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class Producto {
	@Id
	@GeneratedValue
	protected Long id;
	protected String titulo;
	protected double precioUnidad;	
	protected int stock;
	protected String img;

	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_producto_editorial"))
	protected Editorial editorial;	
	
	
	/*@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="producto", fetch = FetchType.EAGER)
	@Builder.Default
	protected List<Valoracion> valoraciones = new ArrayList<>();*/
	
	
	public void addToEditorial(Editorial editorial) {
		this.editorial=editorial;
		editorial.getProductos().add(this);
	}
	
	public void removeFromEditorial(Editorial editorial) {
		editorial.getProductos().remove(this);
		this.editorial = null;
	}

	
	

	
	
}
