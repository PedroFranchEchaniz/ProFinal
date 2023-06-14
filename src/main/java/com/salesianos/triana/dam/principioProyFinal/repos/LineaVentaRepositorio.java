package com.salesianos.triana.dam.principioProyFinal.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianos.triana.dam.principioProyFinal.model.LineaVenta;

@Repository
public interface LineaVentaRepositorio extends JpaRepository <LineaVenta, Long> {

}
