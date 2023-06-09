package com.salesianos.triana.dam.principioProyFinal;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.salesianos.triana.dam.principioProyFinal.repos.ClienteRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainDeMentira {
	private final ClienteRepositorio repo;
	private final PasswordEncoder passwordEncoder;
	
	
}