package com.salesianos.triana.dam.principioProyFinal.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;
import com.salesianos.triana.dam.principioProyFinal.service.ClienteServicio;
import com.salesianos.triana.dam.principioProyFinal.service.VentaServicio;



@Controller
public class ClienteController {
	
	@Autowired
	ClienteServicio clienteServicio;
	
	@Autowired
	VentaServicio ventaServicio;
	
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
	
	@GetMapping("admin/editarCliente/{id}")
	public String editarCliente(@PathVariable("id") Long id, Model model) {
		Optional<Cliente> cEditar = clienteServicio.findById(id);
		if(cEditar.isPresent()) {
			model.addAttribute("cliente", cEditar.get());			
			return "altaUsuario";
		}else {
			return "redirect:/admin/nuevoUsuario";
		}
	}
	
	@PostMapping("admin/editarCliente/submit")
	public String procesarEdicionCliente(@ModelAttribute("cliente") Cliente c) {
		clienteServicio.edit(c);
		return "redirect:/admin/listaClientes";
	}	

	
	@GetMapping("admin/borrarCliente/{id}")
	public String borrarEditorial (@PathVariable("id") Long id, Model model){
		Optional<Cliente> eliminarCliente = clienteServicio.findById(id);		
		if(eliminarCliente.isPresent()) {
			clienteServicio.delete(eliminarCliente.get());
			return "redirect:/admin/listaClientes";
		}else {
			return "index";
		}
	}	
	
	
	@GetMapping ("user/editarUsuario")
	public String monstrarMisDatos (Model model, @AuthenticationPrincipal Cliente c) {		
			model.addAttribute("cliente", c);
			return "misDatos";		
	}
	
	@PostMapping ("/editarUsuario/submit")
	public String procesarMisDatos (@ModelAttribute("cliente") @AuthenticationPrincipal Cliente u) {
		clienteServicio.edit(u);
		return "redirect:/";
	}
	
	@GetMapping ("user/misCompras")
	public String misCompras (@AuthenticationPrincipal Cliente u, Model model) {
		model.addAttribute("ventas", ventaServicio.findByIdCliente(u));
		return "comprasUsuario";
		
	}
}
