package com.monitora.monitoralog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Erro {

	private Integer Status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<CampoErro> campos;
	
	@AllArgsConstructor
	@Getter
	public static class CampoErro {
		private String nome;
		private String message;
	}
	
}
