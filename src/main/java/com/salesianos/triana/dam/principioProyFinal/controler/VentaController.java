package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianos.triana.dam.principioProyFinal.service.ProductoServicio;
import com.salesianos.triana.dam.principioProyFinal.service.VentaServicio;

@Controller
public class VentaController {

	@Autowired
	private VentaServicio ventaServicio;
	
	@Autowired
	private ProductoServicio productoServicio;
	
	@GetMapping("/cesta")
	public String mostrarCarrito (Model model) {
		model.addAttribute("producto", ventaServicio.getProductosInCart());
		return "carrito";
	}
	
	@GetMapping("/productoAcarrito/{id}")
	public String productoAcarrito(@PathVariable("id") Long id, Model model) {
		ventaServicio.addProducto(productoServicio.findById(id).orElse(null));
		return "redirect:/cesta";
	}
}
