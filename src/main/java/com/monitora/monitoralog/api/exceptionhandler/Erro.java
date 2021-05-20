package com.monitora.monitoralog.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Erro {

	private Integer Status;
	private OffsetDateTime dataHora;
	private String titulo;
	private List<CampoErro> campos;
	
	@AllArgsConstructor
	@Getter
	public static class CampoErro {
		private String nome;
		private String message;
	}
	
}
