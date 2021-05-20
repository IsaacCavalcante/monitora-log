package com.monitora.monitoralog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.monitora.monitoralog.domain.model.Cliente;
import com.monitora.monitoralog.domain.model.Entrega;
import com.monitora.monitoralog.domain.repository.EntregaRepository;
import com.monitora.monitoralog.domain.service.EntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private EntregaService entregaService;
	private EntregaRepository entregaRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega criar(@Valid @RequestBody Entrega entrega) {
		return entregaService.criar(entrega);
	}
	
	@GetMapping
	public List<Entrega> bescar() {
		return entregaRepository.findAll();
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entrega))
				.orElse(ResponseEntity.notFound().build());
		
//		Optional<Entrega> entrega = entregaRepository.findById(entregaId)
//		if(entrega.isPresent()) {
//			return ResponseEntity.ok(entrega.get());
//		}
//		
//		return ResponseEntity.notFound().build();
	}

}
