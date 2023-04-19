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

public class Valoracion {
	
	@Id
	@GeneratedValue
	private Long id;
	private double puntuacion;
	private String comentario;
	
	@ManyToOne
	@JoinColumn (foreignKey = @ForeignKey(name="fk_valoracion_cliente"))
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn (foreignKey = @ForeignKey(name = "fk_valoracion_producto"))
	private Producto producto;
	
	public void addToCliente(Cliente cliente) {
		this.cliente=cliente;
		cliente.getValoraciones().add(this);
	}
	
	public void removeFromCliente (Cliente cliente) {
		cliente.getValoraciones().remove(this);
		this.cliente=null;
	}
	
	public void addToProducto (Producto producto) {
		this.producto=producto;
		producto.getValoraciones().add(this);
	}
	
	public void removeFromProducto (Producto producto) {
		producto.getValoraciones().remove(this);
		this.producto=null;
	}
}
