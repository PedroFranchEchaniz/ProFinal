package com.salesianos.triana.dam.principioProyFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.model.Valoracion;
import com.salesianos.triana.dam.principioProyFinal.model.ValoracionPk;
import com.salesianos.triana.dam.principioProyFinal.repos.ValoracionRepositorio;
import com.salesianos.triana.dam.principioProyFinal.repos.VentaRepositorio;

@Service
public class ValoracionesServicio extends BaseServiceImpl<Valoracion, ValoracionPk, ValoracionRepositorio> {
	
	@Autowired
	ValoracionRepositorio valoracionRepositorio;
	
	public List<Valoracion> mostrarValoraciones (Producto p){
		return valoracionRepositorio.valoraciones(p.getId());
	}
	
}
