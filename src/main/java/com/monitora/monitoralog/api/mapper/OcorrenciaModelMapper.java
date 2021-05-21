package com.monitora.monitoralog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.monitora.monitoralog.api.model.OcorrenciaModel;
import com.monitora.monitoralog.api.model.input.OcorrenciaInput;
import com.monitora.monitoralog.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaModelMapper {
	
	private ModelMapper modelMapper;
	
	public OcorrenciaModel toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaModel.class);
	}
	
	public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream()
				.map(ocorrencia -> this.toModel(ocorrencia))
				.collect(Collectors.toList());
	}
	
	public Ocorrencia toEntity(OcorrenciaInput ocorrencia) {
		return modelMapper.map(ocorrencia, Ocorrencia.class);
	}
	
}
