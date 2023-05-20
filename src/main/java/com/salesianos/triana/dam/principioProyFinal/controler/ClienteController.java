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
public class ClienteController {
	
	@Autowired
	ClienteServicio clienteServicio;
	
	@GetMapping("/admin/listaClientes")
	public String listaClientes (Model model) {
		model.addAttribute("listaClientes", clienteServicio.findAll());
		return"listaClientes";
	}
	
	@GetMapping ("/admin/nuevoUsuario")
	public String formularioUsuario (Model model) {
		model.addAttribute("cliente", new Cliente());
		return "altaUsuario";
	}
	
	@PostMapping("/admin/nuevoUsuario/submit")
		public String procesarFormularioCliente(@ModelAttribute("cliente") Cliente u) {
			clienteServicio.save(u);
			return "redirect:/admin/listaClientes";
		}
	
	@GetMapping ("user/editarUsuario")
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
