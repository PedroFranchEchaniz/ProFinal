package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@GetMapping("/")
	public String me() {

		Cliente c = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		System.out.println(c.toString());

		return "misDatos";
	}

	@GetMapping("/me2")
	public String me2(@AuthenticationPrincipal Cliente c) {

		System.out.println(c.toString());

		return "perfil";
	}
	
	@GetMapping ("/nuevoUsuario")
	public String formularioUsuario (Model model) {
		model.addAttribute("cliente", new Cliente());
		return "altaUsuario";
	}
	
	@PostMapping("/nuevoUsuario/submit")
		public String procesarFormularioCliente(@ModelAttribute("cliente") Cliente u) {
			clienteServicio.save(u);
			return "misDatos";
		}
	
	@GetMapping ("/editarUsuario/{id}")
	public String monstrarMisDatos (@PathVariable("id") Long id, Model model) {
		
		Cliente uEditar = clienteServicio.findById(id).orElse(null);
		if (uEditar != null) {
			model.addAttribute("cliente", uEditar);
			return "misDatos";
		}else {
			return "redirect:/nuevoUsuario";
		}
	}
	
	@PostMapping ("/editarUsuario/submit")
	public String procesarMisDatos (@ModelAttribute("cliente") Cliente u) {
		clienteServicio.edit(u);
		return "misDatos";
	}
}
