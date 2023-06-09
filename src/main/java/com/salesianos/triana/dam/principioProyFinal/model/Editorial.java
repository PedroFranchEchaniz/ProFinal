package com.salesianos.triana.dam.principioProyFinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Editorial {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String direccion;
	private String email;
	private String tlf;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="editorial", fetch = FetchType.EAGER)
	@Builder.Default
	private List <Producto> productos = new ArrayList<>();
	
}