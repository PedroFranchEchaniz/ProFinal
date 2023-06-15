package com.salesianos.triana.dam.principioProyFinal.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.model.Venta;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta, Long> {

		@Query("Select v from Venta v where cliente_id = ?1")
		public List<Venta> buscarPorIdCliente (Long id);
		
		@Query("SELECT COUNT(lv.producto.id) FROM Venta v JOIN v.lineaVenta lv WHERE lv.producto = :producto")
		public int countProductoLineaVenta(@Param("producto") Producto producto);
		
		@Query("SELECT lv.producto FROM Venta v JOIN v.lineaVenta lv GROUP BY lv.producto.id ORDER BY SUM(lv.cantidad) DESC")
		public Page<Producto> productosMasVendidos(Pageable pageable);
	
}		
 