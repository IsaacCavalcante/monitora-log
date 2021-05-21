package com.monitora.monitoralog.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monitora.monitoralog.domain.exception.EntidadeNaoEncontrada;
import com.monitora.monitoralog.domain.model.Cliente;
import com.monitora.monitoralog.domain.model.Entrega;
import com.monitora.monitoralog.domain.model.StatusEntrega;
import com.monitora.monitoralog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EntregaService {

	private EntregaRepository entregaRepository;
	private ClienteService clienteService;
	
	@Transactional
	public Entrega criar(Entrega entrega) {
		
		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
		entrega.setCliente(cliente);
		
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId).orElseThrow(() -> new EntidadeNaoEncontrada("Entrega não encontrada"));
	}
	
	public Entrega finalizar(Long entregId) {
		Entrega entrega = buscar(entregId);
		
		entrega.finalizar();
		
		return entregaRepository.save(entrega);
	}
}
