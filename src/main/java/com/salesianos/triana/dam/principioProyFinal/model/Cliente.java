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
public class Cliente {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String apellidos;
	private String nombreUsuario;
	private String contrasenia;
	private String correoElectronico;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="cliente", fetch = FetchType.EAGER)
	@Builder.Default
	private List <Valoracion> valoraciones = new ArrayList<>();
}
