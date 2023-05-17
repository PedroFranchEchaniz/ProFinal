package com.salesianos.triana.dam.principioProyFinal.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianos.triana.dam.principioProyFinal.model.Producto;
import com.salesianos.triana.dam.principioProyFinal.service.CarritoServicio;
import com.salesianos.triana.dam.principioProyFinal.service.ProductoServicio;

@Controller
public class VentaController {

	@Autowired
	private CarritoServicio carritoServicio;	

	@Autowired
	private ProductoServicio productoServicio;

	@GetMapping("/cesta")
	public String controladorCarrito(Model model) {
		if (model.addAttribute("productos", carritoServicio.getProductsInCart()) == null)
			return "redirect:/";
		return "carrito";
	}

	@GetMapping("/productoACarrito/{id}")
	public String productoACarrito(@PathVariable("id") long id, Model model) {

		carritoServicio.addProducto(productoServicio.findById(id).orElse(null));	
		
		return "redirect:/cesta";

	}

	@GetMapping("/borrarProducto/{id}")
	public String removeProductFromCart(@PathVariable("id") long id) {

		Optional<Producto> borrarProd = productoServicio.findById(id);

		if (borrarProd != null) {
			carritoServicio.removeProducto(borrarProd.get());
			return "redirect:/private/cesta";
		} else {
			return "carrito";

		}
	}

	@ModelAttribute("total_carrito")
	public Double calcularPrecioFinal() {
		return carritoServicio.calcularTotalCarrito();

	}
	
	@GetMapping("/checkout")
	public String guardarVenta(@AuthenticationPrincipal UserDetails user) {
		carritoServicio.checkoutCarrito(user.getUsername());

		return "redirect:/cesta";
	}
}
