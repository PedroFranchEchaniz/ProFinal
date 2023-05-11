package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/inicio")
	public String portada(Model model) {		
		return "portada";
	}
}
