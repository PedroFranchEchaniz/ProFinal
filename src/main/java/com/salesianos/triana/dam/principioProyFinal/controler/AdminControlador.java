package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianos.triana.dam.principioProyFinal.service.ClienteServicio;

@Controller
@RequestMapping("/admin")
public class AdminControlador {
	
	@Autowired
	private ClienteServicio clienteServicio;

	@GetMapping("/listaEditorial")
	public String index() {
		return "redirect:/list";
	}
	
	@GetMapping("/listaCliente")
		public String listarTodos (Model model) {
			model.addAttribute("listaClientes", clienteServicio.findAll());
			return "listaClientes";
		}
	
}