package com.salesianos.triana.dam.principioProyFinal.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.w3c.dom.ls.LSResourceResolver;

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
public class Venta {

	@Id
	@GeneratedValue
	private Long id;
	private LocalDate fecha;	
	private double total;
	private boolean cierreCompra;
	
	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy = "venta", fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<LineaVenta> lineaVenta = new ArrayList<>();
	
	public void addLineaVenta (LineaVenta lv) {
		lv.setVenta(this);
		this.lineaVenta.add(lv);
	}
	
	public void removeLineaVenta (LineaVenta lv) {
		this.lineaVenta.remove(lv);
		lv.setVenta(null);
	}
}
