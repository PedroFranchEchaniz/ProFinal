package com.salesianos.triana.dam.principioProyFinal.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.principioProyFinal.formsBeans.SearchBean;
import com.salesianos.triana.dam.principioProyFinal.model.Cliente;
import com.salesianos.triana.dam.principioProyFinal.repos.ClienteRepositorio;
import com.salesianos.triana.dam.principioProyFinal.service.ClienteServicio;
import com.salesianos.triana.dam.principioProyFinal.service.VentaServicio;

import lombok.RequiredArgsConstructor;

@Controller
@Component
@RequiredArgsConstructor
public class ClienteController {
	
	private final PasswordEncoder passwordEncoder;

	@Autowired
	ClienteServicio clienteServicio;

	@Autowired
	VentaServicio ventaServicio;

	@GetMapping("/admin/listaClientes")
	public String listaClientes(Model model) {
		model.addAttribute("listaClientes", clienteServicio.findAll());
		model.addAttribute("busqueda", new SearchBean());
		return "listaClientes";
	}

	@GetMapping("/admin/nuevoUsuario")
	public String formularioUsuario(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "altaUsuario";
	}

	@PostMapping("/admin/nuevoUsuario/submit")
	public String procesarFormularioCliente(@ModelAttribute("cliente") Cliente u) {		
		String code = passwordEncoder.encode(u.getPassword());
		u.setPassword(code);
		clienteServicio.save(u);
		return "redirect:/admin/listaClientes";
	}

	@GetMapping("admin/editarCliente/{id}")
	public String editarCliente(@PathVariable("id") Long id, Model model) {
		Optional<Cliente> cEditar = clienteServicio.findById(id);
		if (cEditar.isPresent()) {
			model.addAttribute("cliente", cEditar.get());
			return "altaUsuario";
		} else {
			return "redirect:/admin/nuevoUsuario";
		}
	}

	@PostMapping("admin/editarCliente/submit")
	public String procesarEdicionCliente(@ModelAttribute("cliente") Cliente c) {
		clienteServicio.edit(c);
		return "redirect:/admin/listaClientes";
	}

	@GetMapping("admin/borrarCliente/{id}")
	public String borrarEditorial(@PathVariable("id") Long id, Model model) {
		Optional<Cliente> eliminarCliente = clienteServicio.findById(id);
		if (eliminarCliente.isPresent()) {
			clienteServicio.delete(eliminarCliente.get());
			return "redirect:/admin/listaClientes";
		} else {
			return "index";
		}
	}

	@GetMapping("user/editarUsuario")
	public String monstrarMisDatos(Model model, @AuthenticationPrincipal Cliente c) {
		model.addAttribute("cliente", c);
		model.addAttribute("total_carrito", ventaServicio.totalCarrito());
		model.addAttribute("cantidadCarrito", ventaServicio.productosEnCarrito());
		return "misDatos";
	}

	@PostMapping("/editarUsuario/submit")
	public String procesarMisDatos(@ModelAttribute("cliente") Cliente u, Authentication authentication) {
		clienteServicio.edit(u);
		Authentication auth = new UsernamePasswordAuthenticationToken(u, authentication.getCredentials(),
				authentication.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
		return "redirect:/";
	}

	@GetMapping("user/misCompras")
	public String misCompras(@AuthenticationPrincipal Cliente u, Model model) {
		model.addAttribute("ventas", ventaServicio.findByIdCliente(u));
		model.addAttribute("total_carrito", ventaServicio.totalCarrito());
		model.addAttribute("cantidadCarrito", ventaServicio.productosEnCarrito());
		model.addAttribute("busqueda", new SearchBean());
		model.addAttribute("productos", ventaServicio.findByIdCliente(u).
				listIterator()
				.next()
				.getLineaVenta()
				.listIterator()
				.next()
				.getProducto());
		return "comprasUsuario";
	}

	@PostMapping("admin/buscarCliente")
	public String buscarPorNombreApellido(@ModelAttribute("busqueda") SearchBean searchBean, Model model) {
		model.addAttribute("listaClientes", clienteServicio.findByNombre(searchBean.getSearch()));
		return "listaClientes";
	}

	@GetMapping("admin/sortear")
	public String generarGanador() {
		ventaServicio.encontrarIdganadora();
		return "redirect:/admin/listaClientes";
	}
}
