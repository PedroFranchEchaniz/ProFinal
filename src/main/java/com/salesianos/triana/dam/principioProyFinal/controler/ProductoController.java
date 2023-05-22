package com.salesianos.triana.dam.principioProyFinal.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.service.ProductoServicio;

@Controller
public class ProductoController {

	@Autowired
	public ProductoServicio productoServicio;
	
	@GetMapping("/infoProducto/{id}")
	public String mostrarProducto (@PathVariable ("id") Long id, Model model) {
		Optional<Producto> producto = productoServicio.findById(id);
		if(producto != null) {
			model.addAttribute("producto", producto.get());
			return "producto";
		}else {
			return "redirect:/";
		}
	}
	
	
	
}
