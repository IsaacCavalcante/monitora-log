package com.monitora.monitoralog.domain.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteEntregaInput {

	@NotNull
	private Long id;
}
