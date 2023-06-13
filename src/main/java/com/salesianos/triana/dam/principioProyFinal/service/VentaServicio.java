package com.salesianos.triana.dam.principioProyFinal.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VentaServicio extends BaseServiceImpl<Venta, Long, VentaRepositorio> {

	@Autowired
	ProductoRepositorio productoRepositorio;

	@Autowired
	VentaRepositorio ventaRepositorio;

	@Autowired
	ProductoServicio productoServicio;
	
	@Autowired
	ClienteServicio clienteServicio;

	private Map<Producto, Integer> producto = new HashMap<>();

	public void addProducto(Producto p) {
		if (producto.containsKey(p)) {
			producto.replace(p, producto.get(p) + 1);
		} else {
			producto.put(p, 1);
		}
	}

	public void removeProducto(Producto p) {
		if (producto.containsKey(p)) {
			if (producto.get(p) > 1)
				producto.replace(p, producto.get(p) - 1);
			else if (producto.get(p) == 1) {
				producto.remove(p);
			}
		}
	}

	public Map<Producto, Integer> getProductosInCart() {
		return Collections.unmodifiableMap(producto);
	}

	public int productosEnCarrito() {
		int cantidad = 0;
		for (Producto p : producto.keySet()) {
			cantidad += producto.get(p);
		}
		System.out.println(cantidad);
		return cantidad;
		/* return producto.values().stream().mapToInt(Integer::intValue).sum(); */
	}

	public double totalCarrito() {
		Map<Producto, Integer> carrito = getProductosInCart();
		double total = 0.0;
		if (carrito != null) {
			for (Producto p : carrito.keySet()) {
				total += (p.getPrecioUnidad() - (p.getPrecioUnidad() * p.getDescuento() / 100)) * carrito.get(p);
			}
			return total;
		}
		return 0.0;
	}

	public void checkoutCarrito(Cliente c) {
		Venta v = new Venta();
		for (Producto p : producto.keySet()) {
			int valor = producto.get(p);
			v.addLineaVenta(LineaVenta.builder()
					.producto(p)
					.cantidad(valor)
					.pvp(p.getPrecioUnidad())
					.subtotal(p.getPrecioUnidad() * valor).build());
			productoServicio.restarStock(p.getId(), valor);
		}
		v.setCliente(c);		
		if(c.getGanador() != null) {
			v.setDescuento(25);
			v.setTotal(totalCarrito()-(totalCarrito()*v.getDescuento()/100));
		}else {		
		v.setTotal(totalCarrito());
		}
		c.setGanador(null);
		clienteServicio.save(c);
		v.setFecha(LocalDateTime.now());
		save(v);
		producto.clear();

	}

	public List<Venta> findByIdCliente(Cliente c) {
		return ventaRepositorio.buscarPorIdCliente(c.getId());
	}

	public int productoEncontrado(Producto p) {
		return ventaRepositorio.countProductoLineaVenta(p);
	}

	public int generarNumeroSorteo() {
		int numMax = ventaRepositorio.findAll().get(ventaRepositorio.findAll().size()-1).getId().intValue();
		int numMin = 1000;
		Random num = new Random(System.nanoTime());
		return num.nextInt(numMax - numMin + 1) + numMin;
	}

	public void encontrarIdganadora() {
		List<Venta> ventas = ventaRepositorio.findAll();
		int numeroGanador = this.generarNumeroSorteo();
		boolean ganador = true;
		for (Venta v : ventas) {			
			if ( numeroGanador == v.getId()) {
				clienteServicio.findById(v.getCliente().getId()).get().setGanador(ganador);
				clienteServicio.save(clienteServicio.findById(v.getCliente().getId()).get());
			}
		}		
	}
	
	public List<Producto> top3() {
	    List<Producto> top = ventaRepositorio.productosMasVendidos();	    
	    return top.subList(0, Math.min(top.size(), 3));	    
	}
	
}
