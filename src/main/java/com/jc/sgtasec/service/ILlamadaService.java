package com.jc.sgtasec.service;

import java.util.List;

import com.jc.sgtasec.model.Llamada;
import com.jc.sgtasec.web.dto.LlamadaDto;

public interface ILlamadaService {
	
	List<Llamada> getAllLlamadas();

	Llamada saveLlamada(Llamada llamada);

	Llamada getLlamadaById(Long id);

	Llamada updateLlamada(Llamada llamada);

	void deleteLlamadaById(Long id);
	
	Llamada mapperToEntity(LlamadaDto source);
	
	LlamadaDto mapperToDTO(Llamada source);
	
	List<LlamadaDto> getListDTO(List<Llamada> lista);
}
