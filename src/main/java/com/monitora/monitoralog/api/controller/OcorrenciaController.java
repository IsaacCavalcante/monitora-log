package com.monitora.monitoralog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.monitora.monitoralog.api.mapper.OcorrenciaModelMapper;
import com.monitora.monitoralog.api.model.OcorrenciaModel;
import com.monitora.monitoralog.api.model.input.OcorrenciaInput;
import com.monitora.monitoralog.domain.model.Entrega;
import com.monitora.monitoralog.domain.model.Ocorrencia;
import com.monitora.monitoralog.domain.service.EntregaService;
import com.monitora.monitoralog.domain.service.OcorrenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	private OcorrenciaService ocorrenciaService;
	private EntregaService entregaService;
	private OcorrenciaModelMapper ocorrenciaModelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		
		Ocorrencia novaOcorrencia = ocorrenciaService.criar(entregaId, ocorrenciaInput.getDescricao());
		return ocorrenciaModelMapper.toModel(novaOcorrencia);
		
	}
	
	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
		Entrega entrega = entregaService.buscar(entregaId);
		return ocorrenciaModelMapper.toCollectionModel(entrega.getOcorrencias());
	}
	
}
