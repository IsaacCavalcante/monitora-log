package com.monitora.monitoralog.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monitora.monitoralog.domain.exception.DomainException;
import com.monitora.monitoralog.domain.model.Cliente;
import com.monitora.monitoralog.domain.model.Entrega;
import com.monitora.monitoralog.domain.model.StatusEntrega;
import com.monitora.monitoralog.domain.repository.ClienteRepository;
import com.monitora.monitoralog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EntregaService {

	private EntregaRepository entregaRepository;
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Entrega criar(Entrega entrega) {
		
		Cliente cliente = clienteRepository.findById(entrega.getCliente().getId())
				.orElseThrow(() -> new DomainException("Cliente não encontrado"));
		
		entrega.setCliente(cliente);
		
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		return entregaRepository.save(entrega);
	}
}
