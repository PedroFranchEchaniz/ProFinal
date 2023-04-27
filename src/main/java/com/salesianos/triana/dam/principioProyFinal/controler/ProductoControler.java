package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianos.triana.dam.principioProyFinal.service.ProductoServicio;

@Controller
public class ProductoControler {

	@Autowired
	private ProductoServicio productoService;
	
	@GetMapping()
	public String listaProductos(Model model) {
		model.addAttribute("lista", productoService.findAll());
		return "listaProductos";
	}
}
