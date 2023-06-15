package com.salesianos.triana.dam.principioProyFinal.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;
import com.salesianos.triana.dam.principioProyFinal.model.Comic;
import com.salesianos.triana.dam.principioProyFinal.model.JuegoMesa;
import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.service.ClienteServicio;
import com.salesianos.triana.dam.principioProyFinal.service.ComicServicio;
import com.salesianos.triana.dam.principioProyFinal.service.JmesaServicio;
import com.salesianos.triana.dam.principioProyFinal.service.ProductoServicio;
import com.salesianos.triana.dam.principioProyFinal.service.ValoracionesServicio;

@Controller
public class ProductoController {

	@Autowired
	public ProductoServicio productoServicio;
	
	@Autowired
	public ComicServicio comicServicio;
	
	@Autowired
	public JmesaServicio jmServicio;
	
	@Autowired 
	public ValoracionesServicio servicioValoracion;
	
	@Autowired
	public ClienteServicio clienteServicio;
	
	/*@GetMapping("/infoProducto/{id}")
	public String mostrarProducto (@PathVariable ("id") Long id, Model model) {
		Optional<Producto> producto = productoServicio.findById(id);
		if(producto != null) {
			model.addAttribute("producto", producto.get());
			return "producto";
		}else {
			return "redirect:/";
		}
	}*/
	
	@GetMapping("/mostrarProducto/{id}")
	public String monstrarProducto(@PathVariable("id") Long id, Model model) {
		Optional <Producto> producto= productoServicio.findById(id);
		Optional <Comic> comic = comicServicio.findById(id);
		Optional<JuegoMesa> jm = jmServicio.findById(id);
		
		if(producto.isPresent()) {
			if(producto.get() instanceof Comic) {
				model.addAttribute("comic", comic.get());
				return "producto";
			}else{
				model.addAttribute("jm", jm.get());
				return "producto2";
			}
		}else{
			return "error";
		}
	}
	
	@GetMapping("/valorarProducto/{id}"){
		public String monstrarProducto(@PathVariable("id") Long id, @AuthenticationPrincipal Cliente c) {
			
		}
	}
	
	
}
