package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String portada(Model model) {		
		return "index";
	}
	
	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}
}
