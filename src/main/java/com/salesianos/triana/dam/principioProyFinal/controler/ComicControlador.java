package com.salesianos.triana.dam.principioProyFinal.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianos.triana.dam.principioProyFinal.formsBeans.SearchBean;
import com.salesianos.triana.dam.principioProyFinal.model.Comic;
import com.salesianos.triana.dam.principioProyFinal.service.ComicServicio;
import com.salesianos.triana.dam.principioProyFinal.service.EditorialServicio;

@Controller
@RequestMapping("/admin")
public class ComicControlador {
	
	@Autowired
	public ComicServicio comicServicio;
	
	@Autowired
	public EditorialServicio editorialServicio;
	
	@GetMapping("/listaC")
	public String listaComics (Model model) {
		model.addAttribute("comics", comicServicio.findAll());
		model.addAttribute("busqueda", new SearchBean());
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
		return "redirect:/admin/listaC";
	}
	
	@GetMapping("/editarComic/{id}")
	public String mostrarFormularioComic(@PathVariable("id") Long id, Model model) {
		Optional<Comic> cEditar = comicServicio.findById(id);		
		if(cEditar.isPresent()) {
			model.addAttribute("comic", cEditar.get());
			model.addAttribute("editoriales", editorialServicio.findAll());
			return "altaComic";
		}else {
			return "redirect:/admin/nuevoComic";
		}
	}
	
	@PostMapping("/editarComic/submit")
	public String procesarFormularoComic(@ModelAttribute("comic") Comic c) {
		comicServicio.edit(c);
		return "redirect:/admin/listaComics";
	}
	
	@GetMapping("/borrarComic/{id}")
	public String borrarEditorial(@PathVariable("id") Long id, Model model) {
		Optional <Comic> cEliminar = comicServicio.findById(id);
		if(cEliminar.isPresent()) {
			comicServicio.delete(cEliminar.get());
		}
		return "redirect:/admin/listaC";
	}
	
	@PostMapping("/buscarComic")
	public String buscarPorTitulo (@ModelAttribute("busqueda") SearchBean searchBean, Model model) {
		model.addAttribute("comics", comicServicio.findByNombre(searchBean.getSearch()));
		return "listaComic";
	}
	
}
