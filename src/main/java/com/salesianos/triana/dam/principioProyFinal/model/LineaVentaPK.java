package com.salesianos.triana.dam.principioProyFinal.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class LineaVentaPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long lineaVenta_id;
	private Long venta_id;
}
