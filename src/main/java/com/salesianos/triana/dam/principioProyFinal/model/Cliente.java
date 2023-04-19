package com.salesianos.triana.dam.principioProyFinal.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

	private Long id;
	private String nombre;
	private String apellidos;
	private String nombreUsuario;
	private String contrasenia;
	private String correoElectronico;
}
