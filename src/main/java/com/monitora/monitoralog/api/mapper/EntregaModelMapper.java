package com.monitora.monitoralog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.monitora.monitoralog.api.model.EntregaModel;
import com.monitora.monitoralog.domain.model.Entrega;
import com.monitora.monitoralog.domain.model.input.EntregaInput;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaModelMapper {
	
	private ModelMapper modelMapper;
	
	public EntregaModel toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaModel.class);
	}
	
	public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream()
				.map(entrega -> this.toModel(entrega))
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInput entrega) {
		return modelMapper.map(entrega, Entrega.class);
	}
	
}
