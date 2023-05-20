package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.principioProyFinal.formsBeans.SearchBean;
import com.salesianos.triana.dam.principioProyFinal.service.ProductoServicio;

@Controller
public class MainController {

	

	@Autowired
	public ProductoServicio productoServicio;
	
	@GetMapping("/")
	public String portada(Model model) {
		model.addAttribute("productos", productoServicio.findAll());
		model.addAttribute("searchForm", new SearchBean());
		return "index";
	}
	
	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}
	
	@PostMapping("/search")
	public String buscarPorTitulo (@ModelAttribute("searchForm") SearchBean searchBean, Model model) {
		model.addAttribute("productos", productoServicio.findByTitulo(searchBean.getSearch()));
		return "index";
	}
	
	@GetMapping("/login")
	public String showLogin () {
		return "login";
	}
	
}