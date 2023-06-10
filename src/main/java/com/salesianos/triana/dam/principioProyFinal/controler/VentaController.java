package com.salesianos.triana.dam.principioProyFinal.controler;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;
import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.model.Venta;
import com.salesianos.triana.dam.principioProyFinal.service.ProductoServicio;
import com.salesianos.triana.dam.principioProyFinal.service.VentaServicio;

@Controller
public class VentaController {

	@Autowired
	private VentaServicio ventaServicio;

	@Autowired
	private ProductoServicio productoServicio;

	@GetMapping("/cesta")
	public String mostrarCarrito(Model model) {
		model.addAttribute("producto", ventaServicio.getProductosInCart());
		return "carrito";
	}

	@GetMapping("/productoAcarrito/{id}")
	public String productoAcarrito(@PathVariable("id") Long id, Model model) {
		Optional<Producto> agregarProducto = productoServicio.findById(id);
		if (agregarProducto != null) {
			ventaServicio.addProducto(agregarProducto.get());
			return "redirect:/cesta";
		} else {
			return "index";
		}

	}

	@GetMapping("/borrarProducto/{id}")
	public String eliminarProducto(@PathVariable("id") Long id, Model model) {
		Optional<Producto> quitarProducto = productoServicio.findById(id);
		if (quitarProducto.isPresent()) {
			ventaServicio.removeProducto(quitarProducto.get());
			return "redirect:/cesta";
		} else {
			return "index";
		}
	}

	@ModelAttribute("total_carrito")
	@Order(1)
	private double totalCarrito() {
		return ventaServicio.totalCarrito();
	}

	@ModelAttribute("descuento")
	private double descuento(@AuthenticationPrincipal Cliente c) {
		if (c.getGanador() != null) {
			return 25.00;
		}else {
			return 00.00;
		}
	}
	
	@ModelAttribute("cantidadCarrito")
	@Order(2)
	private int productosEnCarrito() {
		int cantidad = 0;
		cantidad = ventaServicio.productosEnCarrito();
		System.out.println(cantidad);
		return cantidad;
	}

	@GetMapping("/checkout")
	private String guardarVenta(@AuthenticationPrincipal Cliente c, Model model) {
		ventaServicio.checkoutCarrito(c);
		return "redirect:/";
	}
	
	@GetMapping("admin/listaVentas")
	public String listaVentas(Model model) {
		model.addAttribute("ventas", ventaServicio.findAll());
		return "listaVentas";
	}
	
	@GetMapping("admin/borrarVenta/{id}")
	public String borrarVenta(@PathVariable("id") Long id, Model model) {
		Optional<Venta> vEliminar = ventaServicio.findById(id);
		if(vEliminar.isPresent()) {
			ventaServicio.delete(vEliminar.get());
		}
		return "redirect:/admin/listaVentas";
	}
	
	@ModelAttribute("totalVentas")
	private double totalVentas() {
		List <Venta> ventas = ventaServicio.findAll();
		double totalGanancia = 0;
		for(Venta venta:ventas) {
			totalGanancia += venta.getTotal();
		}
		return totalGanancia;
	}

}
