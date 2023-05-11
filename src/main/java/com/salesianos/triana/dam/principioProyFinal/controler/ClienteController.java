package com.salesianos.triana.dam.principioProyFinal.controler;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;



@Controller
@RequestMapping("/user")
public class ClienteController {

	@GetMapping("/")
	public String me() {

		Cliente c = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		System.out.println(c.toString());

		return "misDatos";
	}

	@GetMapping("/me2")
	public String me2(@AuthenticationPrincipal Cliente c) {

		System.out.println(c.toString());

		return "perfil";
	}
}
