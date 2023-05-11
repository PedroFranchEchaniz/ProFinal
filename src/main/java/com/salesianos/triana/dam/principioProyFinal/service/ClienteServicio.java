package com.salesianos.triana.dam.principioProyFinal.service;



<<<<<<< HEAD
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
=======
>>>>>>> 9b738cad789781d9c232ece32f7c0a942644b393
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.principioProyFinal.model.Cliente;
import com.salesianos.triana.dam.principioProyFinal.repos.ClienteRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServicio extends BaseServiceImpl <Cliente, Long, ClienteRepositorio> implements UserDetailsService{

private final ClienteRepositorio repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findFirstByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Error al buscar el usuario"));
	}

}
