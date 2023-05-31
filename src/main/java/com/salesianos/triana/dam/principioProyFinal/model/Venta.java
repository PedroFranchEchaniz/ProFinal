package com.salesianos.triana.dam.principioProyFinal.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
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
public class Venta {

	@Id
	@GeneratedValue
	private Long id;
	private LocalDateTime fecha;	
	private double total;
	private double descuento;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_venta_cliente"))
	private Cliente cliente;
	
	public void addToCliente (Cliente c) {
		this.cliente=c;
		c.getVentas().add(this);
	}
	
	public void removeFromCliente (Cliente c) {
		c.getVentas().remove(this);
		this.cliente=null;
	}
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy = "venta", fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<LineaVenta> lineaVenta = new ArrayList<>();
	
	public List<LineaVenta> getLineaVenta(){
		return Collections.unmodifiableList(lineaVenta);
	}
	
	public void addLineaVenta (LineaVenta lv) {
		lv.getLineaventaPK().setLineaVenta_id(generarId());
		lv.setVenta(this);
		this.lineaVenta.add(lv);
	}
	
	public void removeLineaVenta (LineaVenta lv) {
		this.lineaVenta.remove(lv);
		lv.setVenta(null);
	}
	
	public long generarId() {
		if(this.lineaVenta.size()>0) {
			return this.lineaVenta.stream()
					.map(LineaVenta::getLineaventaPK)
					.map(LineaVentaPK::getLineaVenta_id)
					.max(Comparator.naturalOrder())
					.orElse(01l)+1l;
		}else
			return 1L;
	}
}
