package com.jc.sgtasec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;
import com.jc.sgtasec.model.Atencion;
import com.jc.sgtasec.repository.IAtencionRepository;
import com.jc.sgtasec.web.dto.AtencionDto;

@Service
public class AtencionServiceImpl implements IAtencionService {

	private IAtencionRepository atencionRepository;
	private JMapper<Atencion, AtencionDto> mapperToEntity;
	private JMapper<AtencionDto, Atencion> mapperToDTO;

	public AtencionServiceImpl(IAtencionRepository atencionRepository) {
		super();
		this.atencionRepository = atencionRepository;
		this.mapperToEntity = new JMapper<>(Atencion.class, AtencionDto.class);
		this.mapperToDTO = new JMapper<>(AtencionDto.class, Atencion.class);
	}
	
	@Override
	public List<Atencion> getAllAtenciones() {
		return atencionRepository.findAll();
	}

	@Override
	public Atencion saveAtencion(Atencion atencion) {
		return atencionRepository.save(atencion);
	}

	@Override
	public Atencion getAtencionById(Long id) {
		return atencionRepository.findById(id).get();
	}

	@Override
	public Atencion updateAtencion(Atencion atencion) {
		return atencionRepository.save(atencion);
	}

	@Override
	public void deleteAtencionById(Long id) {
		atencionRepository.deleteById(id);		
	}

	@Override
	public Atencion mapperToEntity(AtencionDto source) {
		Atencion atencion = new Atencion();
		atencion = mapperToEntity.getDestination(source);		
		return atencion;
	}

	@Override
	public AtencionDto mapperToDTO(Atencion source) {
		AtencionDto alertaDto = new AtencionDto();
		alertaDto = mapperToDTO.getDestination(source);		
		return alertaDto;
	}

	@Override
	public List<AtencionDto> getListDTO(List<Atencion> lista) {
		List<AtencionDto> listDTO = new ArrayList<AtencionDto>();
		
		for (Atencion atencion : getAllAtenciones()) {
			listDTO.add(mapperToDTO(atencion));
		}
		return listDTO;
	}

}
