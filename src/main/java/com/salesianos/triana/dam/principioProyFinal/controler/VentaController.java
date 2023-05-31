package com.salesianos.triana.dam.principioProyFinal.controler;

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
	private double totalCarrito() {
		return ventaServicio.totalCarrito();
	}

	@ModelAttribute("descuento")
	private double descuent() {
		if (ventaServicio.totalCarrito() >= 125) {
			return (ventaServicio.totalCarrito() * 0.25);
		} else if (ventaServicio.totalCarrito() < 125) {
			return 0;
		} else {
			return 0;
		}
	}
	
	@ModelAttribute("cantidadCarrito")
	private int total() {
		
	}

	@GetMapping("/checkout")
	private String guardarVenta(@AuthenticationPrincipal Cliente c, Model model) {
		/*
		 * boolean hasEnoughStock = ventaServicio.cantidadStock(); if (!hasEnoughStock)
		 * { model.addAttribute("error", "No hay suficiente stock de algún producto.");
		 * return "carrito"; // o la vista que desees mostrar en caso de error }
		 */

		ventaServicio.checkoutCarrito(c);
		return "redirect:/";
	}

}
