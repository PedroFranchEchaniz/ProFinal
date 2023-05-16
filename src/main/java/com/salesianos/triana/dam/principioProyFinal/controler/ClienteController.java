package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;
import com.salesianos.triana.dam.principioProyFinal.service.ClienteServicio;



@Controller
@RequestMapping("/user")
public class ClienteController {
	
	@Autowired
	ClienteServicio clienteServicio;	
	
	@GetMapping ("/nuevoUsuario")
	public String formularioUsuario (Model model) {
		model.addAttribute("cliente", new Cliente());
		return "altaUsuario";
	}
	
	@PostMapping("/nuevoUsuario/submit")
		public String procesarFormularioCliente(@AuthenticationPrincipal Cliente u) {
			clienteServicio.save(u);
			return "misDatos";
		}
	
	@GetMapping ("/editarUsuario")
	public String monstrarMisDatos (Model model, @AuthenticationPrincipal Cliente c) {		
			model.addAttribute("cliente", c);
			return "misDatos";		
	}
	
	@PostMapping ("/editarUsuario/submit")
	public String procesarMisDatos (@ModelAttribute("cliente") @AuthenticationPrincipal Cliente u) {
		clienteServicio.edit(u);
		return "misDatos";
	}
}