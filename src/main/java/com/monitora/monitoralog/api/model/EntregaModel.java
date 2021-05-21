package com.monitora.monitoralog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.monitora.monitoralog.domain.model.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaModel {

	private Long id;
	
	private String nomeCliente;
	
	private DestinatarioModel destinatario;
	
	private BigDecimal taxa;

	private StatusEntrega status;

	private OffsetDateTime DataPedido;

	private OffsetDateTime dataFinalizacao;
}
