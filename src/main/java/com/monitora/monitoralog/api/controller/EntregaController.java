package com.monitora.monitoralog.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.monitora.monitoralog.domain.model.Entrega;
import com.monitora.monitoralog.domain.service.EntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private EntregaService entregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega criar(@RequestBody Entrega entrega) {
		return entregaService.criar(entrega);
	}

}
