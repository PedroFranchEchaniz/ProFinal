package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;
import com.salesianos.triana.dam.principioProyFinal.service.ClienteServicio;


@Controller
public class ClienteController {

	@Autowired
	private ClienteServicio  clienteServicio;	
	
	
	@GetMapping("/nuevoCliente")
	public String formularioCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "login";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarFormularioCliente(@ModelAttribute("cliente") Cliente c) {
		clienteServicio.save(c);
		return "portada2";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {		
		model.addAttribute("cliente", clienteServicio.findById(id));
		return "misDatos";
	}

}
