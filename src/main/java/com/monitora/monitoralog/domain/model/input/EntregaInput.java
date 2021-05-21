package com.monitora.monitoralog.domain.model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaInput {
	
	@Valid
	@NotNull
	private ClienteEntregaInput cliente;
	
	@Valid
	@NotNull
	private DestinatarioInput destinatario;
	
	private BigDecimal taxa;
	
}
