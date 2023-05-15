package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "listaComic";
	}
	
	@GetMapping("/nuevoComic")
	public String nuevoComic(Model model) {
		model.addAttribute("comic", new Comic());
		model.addAttribute("editoriales", editorialServicio.findAll());
		return "altaComic";
	}
	
	@PostMapping("/nuevoComic/submit")
	public String submitNuevoComic(@ModelAttribute("comic") Comic c) {		
		comicServicio.save(c);
		return "redirect:/listaComics";
	}
	
	@GetMapping("/editarComic/{id}")
	public String mostrarFormularioComic(@PathVariable("id") Long id, Model model) {
		Comic cEditar = comicServicio.findById(id).orElse(null);
		if(cEditar != null) {
			model.addAttribute("comic", cEditar);
			model.addAttribute("editoriales", editorialServicio.findAll());
			return "altaComic";
		}else {
			return "redirect:/nuevoComic";
		}
	}
	
	@PostMapping("/editarComic/submit")
	public String procesarFormularoComic(@ModelAttribute("comic") Comic c) {
		comicServicio.edit(c);
		return "redirect:/listaComics";
	}
	
	@GetMapping("/borrarComic/{id}")
	public String borrarEditorial(@PathVariable("id") Long id, Model model) {
		Comic cEliminar = comicServicio.findById(id).orElse(null);
		if(cEliminar != null) {
			comicServicio.delete(cEliminar);
		}
		return "redirect:/listaComics";
	}
}
