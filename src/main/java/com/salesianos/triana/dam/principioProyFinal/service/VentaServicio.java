package com.salesianos.triana.dam.principioProyFinal.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;
import com.salesianos.triana.dam.principioProyFinal.model.LineaVenta;
import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.model.Venta;
import com.salesianos.triana.dam.principioProyFinal.repos.ProductoRepositorio;
import com.salesianos.triana.dam.principioProyFinal.repos.VentaRepositorio;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VentaServicio extends BaseServiceImpl <Venta, Long, VentaRepositorio> {

	@Autowired
	ProductoRepositorio productoRepositorio;
	
	@Autowired
	VentaRepositorio ventaRepositorio;
	
	@Autowired 
	ProductoServicio productoServicio;
	
	private Map <Producto, Integer> producto = new HashMap<>();
	
	
			
	public void addProducto (Producto p) {
		if(producto.containsKey(p)) {
			producto.replace(p, producto.get(p)+1);
		}else {
			producto.put(p, 1);
		}
	}
	
	public void removeProducto (Producto p) {
		if(producto.containsKey(p)) {
			if(producto.get(p)>1)
				producto.replace(p, producto.get(p)-1);
			else if (producto.get(p)==1) {
				producto.remove(p);
			}
		}
	}
	
	public Map<Producto, Integer>getProductosInCart(){
		return Collections.unmodifiableMap(producto);
	}
	
	public double totalCarrito() {
		Map<Producto, Integer> carrito = getProductosInCart();
		double total = 0.0;
		if(carrito != null){
			for(Producto p:carrito.keySet()) {
				total += p.getPrecioUnidad()*carrito.get(p);
			}
			return total;
		}
		return 0.0;
	}
	
	 public void checkoutCarrito(Cliente c) {
	    	Venta v = new Venta();
		  for(Producto p : producto.keySet()) {
			  int valor = producto.get(p);
			  v.addLineaVenta(
					  LineaVenta.builder()
					  .producto(p)
					  .cantidad(valor)
					  .pvp(p.getPrecioUnidad())
					  .subtotal(p.getPrecioUnidad()*valor)
					  .build());
			  productoServicio.restarStock(p.getId(), valor);
		  }
		  v.setCliente(c);
		  v.setFecha(LocalDate.now());
		  v.setTotal(totalCarrito());		  
		  save(v);
		  producto.clear();
	    	/*LineaVenta lv;
	    	List<LineaVenta> lista = new ArrayList<LineaVenta>();
	    	Venta venta = new Venta();
	    	
	    	for (Map.Entry<Producto , Integer> carrito : producto.entrySet()) {
	    		
	    		lv= LineaVenta.builder()
				    		.producto(carrito.getKey())
				    		.cantidad(carrito.getValue())
				    		.build();
	    		lista.add(lv);
	    		venta.addLineaVenta(lv);
	    		
			}
	    	
	    	venta = Venta.builder()
	    			.total(totalCarrito())
	    			.fecha(LocalDate.now())	    			
	    			.build();
	    	
	    	venta.setLineaVenta(lista);
	    	
	    	producto.clear();*/
	    }
	 
	 public List<Venta> findByIdCliente (Cliente c){
		 return ventaRepositorio.buscarPorIdCliente(c.getId());
	 }
	  
}
