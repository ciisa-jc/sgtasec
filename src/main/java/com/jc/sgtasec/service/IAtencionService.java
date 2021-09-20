package com.jc.sgtasec.service;

import java.util.List;

import com.jc.sgtasec.model.Atencion;
import com.jc.sgtasec.web.dto.AtencionDto;

public interface IAtencionService {
	List<Atencion> getAllAtenciones();

	Atencion saveAtencion(Atencion atencion);

	Atencion getAtencionById(Long id);

	Atencion updateAtencion(Atencion atencion);

	void deleteAtencionById(Long id);
	
	Atencion mapperToEntity(AtencionDto source);
	
	AtencionDto mapperToDTO(Atencion source);
	
	List<AtencionDto> getListDTO(List<Atencion> lista);

}
