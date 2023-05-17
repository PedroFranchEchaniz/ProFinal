package com.salesianos.triana.dam.principioProyFinal.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LineaVenta {

	@EmbeddedId
	@Builder.Default
	private LineaVentaPK lineaventaPK = new LineaVentaPK();
	
	private int cantidad;
	private double pvp;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_lieneaVenta_producto"))
	private Producto producto;
	
	@ManyToOne
	@MapsId("venta_id")
	@JoinColumn(name="aviob_id")
	private Venta venta;
}
