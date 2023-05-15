package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.triana.dam.principioProyFinal.model.Comic;
import com.salesianos.triana.dam.principioProyFinal.service.ComicServicio;
import com.salesianos.triana.dam.principioProyFinal.service.EditorialServicio;

@Controller
public class ComicControlador {
	
	@Autowired
	public ComicServicio comicServicio;
	
	@Autowired
	public EditorialServicio editorialServicio;
	
	@GetMapping("/listaComics")
	public String index (Model model) {
		model.addAttribute("comics", comicServicio.findAll());
		return "listaComic.html";
	}
	
	@GetMapping("/nuevoComic")
	public String nuevoComic(Model model) {
		model.addAttribute("comic", new Comic());
		model.addAttribute("editoriales", editorialServicio.findAll());
		return "altaComic";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNuevoComic(Comic comic, Model model) {
		comicServicio.save(comic);
		return "redirect:/admin/producto/";
	}
}
