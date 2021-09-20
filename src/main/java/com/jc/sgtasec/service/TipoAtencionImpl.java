package com.jc.sgtasec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;
import com.jc.sgtasec.model.TipoAtencion;
import com.jc.sgtasec.repository.ITipoAtencionRepository;
import com.jc.sgtasec.web.dto.TipoAtencionDto;

@Service
public class TipoAtencionImpl implements ITipoAtencionService {
	
	private ITipoAtencionRepository tipoAtencionRepository;
	private JMapper<TipoAtencion, TipoAtencionDto> mapperToEntity;
	private JMapper<TipoAtencionDto, TipoAtencion> mapperToDTO;
	
	public TipoAtencionImpl(ITipoAtencionRepository tipoAtencionRepository) {
		super();
		this.tipoAtencionRepository = tipoAtencionRepository;
		this.mapperToEntity = new JMapper<>(TipoAtencion.class, TipoAtencionDto.class);
		this.mapperToDTO = new JMapper<>(TipoAtencionDto.class, TipoAtencion.class);
	} 

	@Override
	public List<TipoAtencion> getAllTipoAtencions() {
		return tipoAtencionRepository.findAll();
	}

	@Override
	public TipoAtencion saveTipoAtencion(TipoAtencion tipoAtencion) {
		return tipoAtencionRepository.save(tipoAtencion);
	}

	@Override
	public TipoAtencion getTipoAtencionById(Long id) {
		return tipoAtencionRepository.findById(id).get();
	}

	@Override
	public TipoAtencion updateTipoAtencion(TipoAtencion tipoAtencion) {
		return tipoAtencionRepository.save(tipoAtencion);
	}

	@Override
	public void deleteTipoAtencionById(Long id) {
		tipoAtencionRepository.deleteById(id);
		
	}

	@Override
	public TipoAtencion mapperToEntity(TipoAtencionDto source) {
		TipoAtencion tipoAtencion = new TipoAtencion();
		tipoAtencion = mapperToEntity.getDestination(source);		
		return tipoAtencion;
	}

	@Override
	public TipoAtencionDto mapperToDTO(TipoAtencion source) {
		TipoAtencionDto tipoAtencionDto = new TipoAtencionDto();
		tipoAtencionDto = mapperToDTO.getDestination(source);		
		return tipoAtencionDto;
	}

	@Override
	public List<TipoAtencionDto> getListTipoAtencionDTO(List<TipoAtencion> lista) {
		List<TipoAtencionDto> listDTO = new ArrayList<TipoAtencionDto>();
		
		for (TipoAtencion tipoAtencion : getAllTipoAtencions()) {
			listDTO.add(mapperToDTO(tipoAtencion));
		}
		return listDTO;
	}

}
