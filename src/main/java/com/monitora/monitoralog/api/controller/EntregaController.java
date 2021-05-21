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

import com.monitora.monitoralog.api.model.DestinatarioModel;
import com.monitora.monitoralog.api.model.EntregaModel;
import com.monitora.monitoralog.domain.model.Destinatario;
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
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> {
					EntregaModel entregaModel = new EntregaModel();
					
					entregaModel.setId(entrega.getId());
					entregaModel.setNomeCliente(entrega.getCliente().getNome());
					entregaModel.setDestinatario(new DestinatarioModel());
					entregaModel.setStatus(entrega.getStatus());
					entregaModel.setTaxa(entrega.getTaxa());
					entregaModel.setDataPedido(entrega.getDataPedido());
					entregaModel.setDataFinalizacao(entrega.getDataFinalizacao());
					
					DestinatarioModel destinatarioModel = entregaModel.getDestinatario();
					Destinatario destinatario = entrega.getDestinatario();
					
					destinatarioModel.setNome(destinatario.getNome());
					destinatarioModel.setLogradouro(destinatario.getLogradouro());
					destinatarioModel.setNumero(destinatario.getNumero());
					destinatarioModel.setComplemento(destinatario.getComplemento());
					destinatarioModel.setBairro(destinatario.getBairro());
					
					return ResponseEntity.ok(entregaModel);
					
				}).orElse(ResponseEntity.notFound().build());
				
		
//		Optional<Entrega> entrega = entregaRepository.findById(entregaId)
//		if(entrega.isPresent()) {
//			return ResponseEntity.ok(entrega.get());
//		}
//		
//		return ResponseEntity.notFound().build();
	}

}
