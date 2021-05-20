package com.monitora.monitoralog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monitora.monitoralog.domain.exception.DomainException;
import com.monitora.monitoralog.domain.model.Cliente;
import com.monitora.monitoralog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {

	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long clientId) {
		return clienteRepository.findById(clientId)
				.orElseThrow(() -> new DomainException("Cliente não encontrado"));
	}
	
	@Transactional
	public Cliente save(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new DomainException("Já existe um cliente cadastrado com esse email");
		}
						
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
