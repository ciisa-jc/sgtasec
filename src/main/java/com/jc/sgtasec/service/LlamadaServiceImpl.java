package com.jc.sgtasec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;
import com.jc.sgtasec.model.Llamada;
import com.jc.sgtasec.repository.ILlamadaRepository;
import com.jc.sgtasec.web.dto.LlamadaDto;

@Service
public class LlamadaServiceImpl implements ILlamadaService {
	
	private ILlamadaRepository llamadaRepository;
	private JMapper<Llamada, LlamadaDto> mapperToEntity;
	private JMapper<LlamadaDto, Llamada> mapperToDTO;
	
	public LlamadaServiceImpl(ILlamadaRepository llamadaRepository) {
		super();
		this.llamadaRepository = llamadaRepository;
		this.mapperToEntity = new JMapper<>(Llamada.class, LlamadaDto.class);
		this.mapperToDTO = new JMapper<>(LlamadaDto.class, Llamada.class);
	}
	
	@Override
	public List<Llamada> getAllLlamadas() {
		return llamadaRepository.findAll();
	}

	@Override
	public Llamada saveLlamada(Llamada llamada) {
		return llamadaRepository.save(llamada);
	}

	@Override
	public Llamada getLlamadaById(Long id) {
		return llamadaRepository.findById(id).get();
	}

	@Override
	public Llamada updateLlamada(Llamada llamada) {
		return llamadaRepository.save(llamada);
	}

	@Override
	public void deleteLlamadaById(Long id) {
		llamadaRepository.deleteById(id);		
	}

	@Override
	public Llamada mapperToEntity(LlamadaDto source) {
		Llamada llamada = new Llamada();
		llamada = mapperToEntity.getDestination(source);		
		return llamada;
	}

	@Override
	public LlamadaDto mapperToDTO(Llamada source) {
		LlamadaDto llamadaDto = new LlamadaDto();
		llamadaDto = mapperToDTO.getDestination(source);		
		return llamadaDto;
	}

	@Override
	public List<LlamadaDto> getListDTO(List<Llamada> lista) {
		List<LlamadaDto> listDTO = new ArrayList<LlamadaDto>();
		
		for (Llamada llamada : getAllLlamadas()) {
			listDTO.add(mapperToDTO(llamada));
		}
		return listDTO;
	}

}
