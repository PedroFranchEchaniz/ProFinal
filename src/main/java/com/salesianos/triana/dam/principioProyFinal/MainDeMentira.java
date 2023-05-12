package com.salesianos.triana.dam.principioProyFinal;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;
import com.salesianos.triana.dam.principioProyFinal.repos.ClienteRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainDeMentira {
	private final ClienteRepositorio repo;
	private final PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() {
		
		Cliente usuario = Cliente.builder()
				.admin(false)
				.username("user")
				//.password("1234")
				.password(passwordEncoder.encode("1234"))
				.build();
		
		Cliente admin = Cliente.builder()
				.admin(true)
				.username("admin")
				.password(passwordEncoder.encode("admin"))
				.build();
		
		repo.saveAll(List.of(usuario, admin));
		
	}
}