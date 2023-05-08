package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;

@Controller
public class MainController {

	@GetMapping("/portada")
	public String portada(Model model) {
		
		return "portada.html";
	}
}
