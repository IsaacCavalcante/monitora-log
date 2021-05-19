package com.monitora.monitoralog.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.monitora.monitoralog.api.domain.model.Cliente;
import com.monitora.monitoralog.api.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
//	@PersistenceContext
//	private EntityManager manager;
	
	@Autowired
	private ClienteRepository clientRepository;

	@GetMapping
	public List<Cliente> listar() {
		return clientRepository.findAll();
	
//		return manager.createQuery("from Cliente", Cliente.class)
//				.getResultList();
//	}
	}
	
	@GetMapping("/{clientId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clientId) {
		return clientRepository.findById(clientId)
				.map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());
		
//		Optional<Cliente> cliente = clientRepository.findById(clientId)
//		if(cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}
//		
//		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clientRepository.save(cliente);
	}
	
	@PutMapping("/{clientId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clientId, @RequestBody Cliente cliente){
		if(!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(clientId);
		cliente = clientRepository.save(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> remover(@PathVariable Long clientId){
		if(!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		clientRepository.deleteById(clientId);
		
		return ResponseEntity.noContent().build();
	}
}
