package com.salesianos.triana.dam.principioProyFinal.controler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianos.triana.dam.principioProyFinal.model.Editorial;
import com.salesianos.triana.dam.principioProyFinal.service.EditorialServicio;

@Controller
@RequestMapping("/admin")
public class EditorialController {

	@Autowired
	HttpSession session;
	
	@Autowired
	private EditorialServicio editorialServicio;

	@GetMapping("/listaEditorial")
	public String listarTodos(Model model) {
		model.addAttribute("lista", editorialServicio.findAll());		
		return "listaEditoriales";
	}

	@GetMapping("/nuevaEditorial")
	public String formularioEditorial(Model model) {
		model.addAttribute("editorial", new Editorial());
		return "altaEditorial";
	}

	@PostMapping("/nuevaEditorial/submit")
		public String procesarFormularioEditorial(@ModelAttribute("editorial") Editorial e) {
		editorialServicio.save(e);
		return "redirect:/admin/listaEditorial"; 
	}
	
	@GetMapping("/editarEditorial/{id}")
	public String monstrarFormularioEdicionEditorial(@PathVariable("id") Long id, Model model) {
		Editorial eEditar = editorialServicio.findById(id).orElse(null);
		if (eEditar != null) {
			model.addAttribute("editorial", eEditar);
			return "altaEditorial";
		}else {
			return "redirect:/admin/nuevaEditorial";
		}
	}
	
	@PostMapping("/editarEditorial/submit")
	public String procesarFormularioEdicion(@ModelAttribute("editorial") Editorial e) {
		editorialServicio.edit(e);
		return "redirect:/admin/listaEditorial";
	}
	
	@GetMapping("/borrarEditorial/{id}")
	public String borrarEditorial(@PathVariable("id") Long id, Model model) {
		
		Editorial eEliminar = editorialServicio.findById(id).orElse(null);
		if (eEliminar != null) {
			editorialServicio.delete(eEliminar);
		}
		return "redirect:/admin/listaEditorial";
	}	
	
}

