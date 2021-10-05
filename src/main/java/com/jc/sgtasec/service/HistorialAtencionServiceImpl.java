package com.jc.sgtasec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;
import com.jc.sgtasec.model.HistorialAtencion;
import com.jc.sgtasec.repository.IHistorialAtencionRepository;
import com.jc.sgtasec.web.dto.HistorialAtencionDto;

@Service
public class HistorialAtencionServiceImpl implements IHistorialAtencionService {
	
	private IHistorialAtencionRepository atencionRepository;
	private JMapper<HistorialAtencion, HistorialAtencionDto> mapperToEntity;
	private JMapper<HistorialAtencionDto, HistorialAtencion> mapperToDTO;

	public HistorialAtencionServiceImpl(IHistorialAtencionRepository atencionRepository) {
		super();
		this.atencionRepository = atencionRepository;
		this.mapperToEntity = new JMapper<>(HistorialAtencion.class, HistorialAtencionDto.class);
		this.mapperToDTO = new JMapper<>(HistorialAtencionDto.class, HistorialAtencion.class);
		
	}

	@Override
	public List<HistorialAtencion> getAllHistorialAtenciones() {
		return atencionRepository.findAll();
	}

	@Override
	public HistorialAtencion saveHistorialAtencion(HistorialAtencion historialAtencion) {
		return atencionRepository.save(historialAtencion);
	}

	@Override
	public HistorialAtencion getHistorialAtencionById(Long id) {
		return atencionRepository.findById(id).get();
	}

	@Override
	public HistorialAtencion updateHistorialAtencion(HistorialAtencion historialAtencion) {
		return atencionRepository.save(historialAtencion);
	}

	@Override
	public void deleteHistorialAtencionById(Long id) {
		atencionRepository.deleteById(id);		
	}

	@Override
	public HistorialAtencion mapperToEntity(HistorialAtencionDto source) {
		HistorialAtencion historialAtencion = new HistorialAtencion();
		historialAtencion = mapperToEntity.getDestination(source);
		return historialAtencion;
	}

	@Override
	public HistorialAtencionDto mapperToDTO(HistorialAtencion source) {
		HistorialAtencionDto historialAtencionDto = new HistorialAtencionDto();
		historialAtencionDto = mapperToDTO.getDestination(source);
		return historialAtencionDto;
	}

	@Override
	public List<HistorialAtencionDto> getListDTO(List<HistorialAtencion> lista) {
		List<HistorialAtencionDto> listDTO = new ArrayList<HistorialAtencionDto>();
		
		for (HistorialAtencion historialAtencion : getAllHistorialAtenciones()) {
			listDTO.add(mapperToDTO.getDestination(historialAtencion));			
		}
		
		return listDTO;
	}

}
