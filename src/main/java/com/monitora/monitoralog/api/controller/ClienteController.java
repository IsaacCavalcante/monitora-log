package com.monitora.monitoralog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitora.monitoralog.api.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("João");
		cliente1.setTelefone("85 30324715");
		cliente1.setEmail("joao@monitoratec.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(1L);
		cliente2.setNome("Maria");
		cliente2.setTelefone("85 999955681");
		cliente2.setEmail("maria@monitoratec.com");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
