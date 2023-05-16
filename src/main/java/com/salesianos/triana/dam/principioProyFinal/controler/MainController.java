package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianos.triana.dam.principioProyFinal.service.ProductoServicio;

@Controller
public class MainController {

	@Autowired
	public ProductoServicio productoServicio;
	
	@GetMapping("/")
	public String portada(Model model) {
		model.addAttribute("productos", productoServicio.findAll());
		return "index";
	}
	
	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}
}