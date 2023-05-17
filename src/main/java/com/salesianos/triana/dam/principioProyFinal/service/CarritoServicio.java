package com.salesianos.triana.dam.principioProyFinal.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.principioProyFinal.model.LineaVenta;
import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.model.Venta;
import com.salesianos.triana.dam.principioProyFinal.repos.ProductoRepositorio;

@Service
public class CarritoServicio {

	@Autowired
	private ProductoRepositorio productoRepository;
	
	@Autowired
	private VentaServicio ventaServicio;
	
	@Autowired
	private LineaVentaService lineaVentaServicio;
	
	private Map<Producto, Integer> products = new HashMap <> ();
	
	
	public CarritoServicio (ProductoRepositorio productorepository) {
		this.productoRepository=productorepository;
	}
	
	public void addProducto (Producto p) {
		if (products.containsKey(p)) {
			products.replace(p, products.get(p)+1);
		}else {
			products.put(p, 1);
		}
	}
	
	
	public void removeProducto (Producto p) {
        if (products.containsKey(p)) {
            if (products.get(p) > 1)
                products.replace(p, products.get(p) - 1);
            else if (products.get(p) == 1) {
                products.remove(p);
            }
        }
	}


    public Map<Producto, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }
    
    public void checkoutCarrito(String nombreUsuario) {
    	
    	LineaVenta lv;
    	List<LineaVenta> lista = new ArrayList<LineaVenta>();
    	Venta venta;
    	
    	for (Map.Entry<Producto , Integer> carrito : products.entrySet()) {
    		
    		lv= LineaVenta.builder()
			    		.producto(carrito.getKey())
			    		.cantidad(carrito.getValue())
			    		.build();
    		lista.add(lv);
    		
		}
    	
    	venta = Venta.builder()
    			.total(calcularTotalCarrito())
    			.fecha(LocalDate.now())
    			.cierreCompra(true)
    			.build();
    	if(!lista.isEmpty()) {
        	ventaServicio.save(venta);
        	
    	}
    	productoRepository.flush();
    	products.clear();
    }
    
public double calcularTotalCarrito() {
    	
    	Map <Producto,Integer> carrito= getProductsInCart();
    	double total=0.0;
    	if (carrito != null) {
        	for (Producto p: carrito.keySet()) {
        		total+=p.getPrecioUnidad()*carrito.get(p);
        	}
        	
        	return total;
    	}
    	
    	return 0.0;
    }
}
