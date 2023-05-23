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
		 model.addAttribute("busqueda", new SearchBean());
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
		 Optional<JuegoMesa> jmEditar = jmServicio.findById(id);
		 if(jmEditar.isPresent()) {
			 model.addAttribute("juegoMesa", jmEditar.get());
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
		Optional <JuegoMesa> jmEliminar = jmServicio.findById(id);
		 if(jmEliminar.isPresent()) {
			 jmServicio.delete(jmEliminar.get());
		 }
		 return "redirect:/admin/listaJM";
	 }
	 
	 @PostMapping("/buscarJuego")
	 public String buscarPorTitulo (@ModelAttribute("busqueda") SearchBean searchBean, Model model) {
		 model.addAttribute("juegosMesa", jmServicio.findByTitulo(searchBean.getSearch()));
		 return "listaJuegosMesa";
	 }
}
