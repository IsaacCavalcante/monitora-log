package com.monitora.monitoralog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monitora.monitoralog.domain.model.Entrega;
import com.monitora.monitoralog.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OcorrenciaService {
	
	private EntregaService entregaService;
	
	@Transactional
	public Ocorrencia criar(Long entregaId, String descricao) {
		Entrega entrega = entregaService.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
	}
	
}
