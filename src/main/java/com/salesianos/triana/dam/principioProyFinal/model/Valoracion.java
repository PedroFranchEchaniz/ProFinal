package com.salesianos.triana.dam.principioProyFinal.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Valoracion {

	@EmbeddedId
	private ValoracionPk valoracionPk = new ValoracionPk();
	
	public Valoracion(Cliente c ,Producto p) {
		this.producto=p;
		this.cliente=c;
	}
	
	private String valoracion;
	
	@ManyToOne
	@MapsId("producto_id")
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	@ManyToOne
	@MapsId("cliente_id")
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	public void addToCliente(Cliente c) {
		c.getValoraciones().add(this);
		this.cliente = c;
	}
	
	public void removeFromCliente (Cliente c) {
		c.getValoraciones().add(this);
		this.cliente = null;
	}
	
	public void addToProducto (Producto p) {
		p.getValoraciones().add(this);
		this.producto = p;
	}
	
	public void removeFromProducto(Producto p) {
		p.getValoraciones().remove(this);
		this.producto = null;
	}
}
