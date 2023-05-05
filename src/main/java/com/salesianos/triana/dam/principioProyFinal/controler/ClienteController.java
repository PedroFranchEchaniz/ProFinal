package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;
import com.salesianos.triana.dam.principioProyFinal.service.ClienteServicio;

@Controller
public class ClienteController {

	@Autowired
	private ClienteServicio  clienteServicio;
	
	@GetMapping({"/","/listaCliente"})
	public String listarClientes(Model model) {
		model.addAttribute("listaClientes", clienteServicio.findAll());
		return "listaClientes";
	}
	
	@GetMapping("/nuevoCliente")
	public String formularioCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "formularioAltaCliente";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarFormularioCliente(@ModelAttribute("cliente") Cliente c) {
		clienteServicio.save(c);
		return "redirect:/";
	}
}
