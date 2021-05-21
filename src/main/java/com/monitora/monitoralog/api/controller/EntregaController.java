package com.monitora.monitoralog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.monitora.monitoralog.api.mapper.EntregaModelMapper;
import com.monitora.monitoralog.api.model.EntregaModel;
import com.monitora.monitoralog.api.model.input.EntregaInput;
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
	private EntregaModelMapper entregaModelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel criar(@Valid @RequestBody EntregaInput entrega) {
		Entrega novaEntrega = entregaService.criar(entregaModelMapper.toEntity(entrega));
		return entregaModelMapper.toModel(novaEntrega);
	}
	
	@GetMapping
	public List<EntregaModel> listar() {
		return entregaModelMapper.toCollectionModel(entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega ->  ResponseEntity.ok(entregaModelMapper.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
				
		
//		Optional<Entrega> entrega = entregaRepository.findById(entregaId)
//		if(entrega.isPresent()) {
//			return ResponseEntity.ok(entrega.get());
//		}
//		
//		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		entregaService.finalizar(entregaId);
	}

}
