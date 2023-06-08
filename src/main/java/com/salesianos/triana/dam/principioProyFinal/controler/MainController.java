package com.salesianos.triana.dam.principioProyFinal.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.principioProyFinal.formsBeans.SearchBean;
import com.salesianos.triana.dam.principioProyFinal.formsBeans.SearchBeanDouble;
import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.service.ProductoServicio;

@Controller
public class MainController {

	

	@Autowired
	public ProductoServicio productoServicio;
	
	@GetMapping("/")
	public String portada(Model model) {
		model.addAttribute("productos", productoServicio.findAll());
		model.addAttribute("searchForm", new SearchBean());
		model.addAttribute("maxYmin", new SearchBeanDouble());
		return "index";
	}
	
	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}
	
	@PostMapping("/search")
	public String buscarPorTitulo (@ModelAttribute("searchForm") SearchBean searchBean, Model model) {
		model.addAttribute("productos", productoServicio.findByTitulo(searchBean.getSearch()));
		model.addAttribute("maxYmin", new SearchBeanDouble());
		return "index";
	}
	
	@PostMapping("/filtrarPrecio")
	public String buscarRangoPrecio (@ModelAttribute("maxYmin") SearchBeanDouble searchBeanDouble, Model model) {
		Double minPrecio = 0.0;
		Double maxPrecio = 1000.0;
		List <Producto> productos;
		if(searchBeanDouble.getMinPrecio() == null && searchBeanDouble.getMaxPrecio() != null) {			
			maxPrecio = searchBeanDouble.getMaxPrecio();
			productos = productoServicio.filtroPrecioMinMax(minPrecio, maxPrecio);
		}else if (searchBeanDouble.getMinPrecio() != null && searchBeanDouble.getMaxPrecio() == null) {
			minPrecio = searchBeanDouble.getMinPrecio();
			productos = productoServicio.filtroPrecioMinMax(minPrecio, maxPrecio);
		}else {
			minPrecio = searchBeanDouble.getMinPrecio();
			maxPrecio = searchBeanDouble.getMaxPrecio();
			productos = productoServicio.filtroPrecioMinMax(minPrecio, maxPrecio);
		}
		
		model.addAttribute("productos", productos);
		model.addAttribute("searchForm", new SearchBean());
		return "index";
	}
	
	@GetMapping("/login")
	public String showLogin () {
		return "login";
	}
	
	@GetMapping("/comics")
	public String comics(Model model) {
		model.addAttribute("productos", productoServicio.listaComics());
		model.addAttribute("searchForm", new SearchBean());
		model.addAttribute("maxYmin", new SearchBeanDouble());
		return "index";
	}
	
	@GetMapping("/juegosMesa")
	public String juegosMesa(Model model) {
		model.addAttribute("productos", productoServicio.listaJuegosMesa());
		model.addAttribute("searchForm", new SearchBean());
		model.addAttribute("maxYmin", new SearchBeanDouble());
		return "index";
	}
	
	@GetMapping("/comicsDescuento")
	public String comicsDescuento(Model model) {
		model.addAttribute("productos", productoServicio.listaComicsDescuento());
		model.addAttribute("searchForm", new SearchBean());
		model.addAttribute("maxYmin", new SearchBeanDouble());
		return "index";
	}
	
	
}