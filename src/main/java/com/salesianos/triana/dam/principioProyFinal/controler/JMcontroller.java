package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianos.triana.dam.principioProyFinal.model.JuegoMesa;
import com.salesianos.triana.dam.principioProyFinal.service.EditorialServicio;
import com.salesianos.triana.dam.principioProyFinal.service.JmesaServicio;

@Controller
@RequestMapping("/admin")
public class JMcontroller {

	 @Autowired
	 JmesaServicio jmServicio;
	 
	 @Autowired
	 EditorialServicio editorialServicio;
	 
	 @GetMapping("/listaJM")
	 public String listaJuegos (Model model) {
		 model.addAttribute("juegosMesa", jmServicio.findAll());
		 return "listaJuegosMesa";
	 }
	 
	 @GetMapping("/nuevoJuegoMesa")
	 public String formularioJM (Model model) {
		 model.addAttribute("juegoMesa", new JuegoMesa());
		 model.addAttribute("editoriales", editorialServicio.findAll());
		 return "altaJuegoMesa";
	 }
	 
	 @PostMapping("/nuevoJuegoMesa/submit")
	 public String procesarFormularioJM(@ModelAttribute("juegoMesa") JuegoMesa jm) {
		 jmServicio.save(jm);
		 return"redirect:/admin/listaJM";
	 }
	 
	 @GetMapping("/editarJuegoMesa/{id}")
	 public String monstrarFormularioJuegoMesa(@PathVariable("id") Long id, Model model) {
		 JuegoMesa jmEditar = jmServicio.findById(id).orElse(null);
		 if(jmEditar != null) {
			 model.addAttribute("juegoMesa", jmEditar);
			 model.addAttribute("editoriales", editorialServicio.findAll());
			 return "altaJuegoMesa";
		 }else {
			 return "redirect:/admin/nuevoJuegoMesa";
		 }
	 }
	 
	 @PostMapping("/edutarJuegoMesa/submit")
	 public String procesarFormularioJuegoMesa(@ModelAttribute("juegoMesa") JuegoMesa m) {
		 jmServicio.edit(m);
		 return "redirec:/admin/listaJM";
	 }
	 
	 @GetMapping("/borrarJuegoMesa/{id}")
	 public String borrarJuegoMesa(@PathVariable("id") Long id, Model model) {
		 JuegoMesa jmEliminar = jmServicio.findById(id).orElse(null);
		 if(jmEliminar != null) {
			 jmServicio.delete(jmEliminar);
		 }
		 return "redirect:/admin/listaJM";
	 }
}
