package com.jc.sgtasec.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;
import com.jc.sgtasec.model.Turno;
import com.jc.sgtasec.repository.ITurnoRepository;
import com.jc.sgtasec.web.dto.TurnoDto;

@Service
public class TurnoServiceImpl implements ITurnoService {
	
	private ITurnoRepository turnoRepository;
	private JMapper<Turno, TurnoDto> mapperToEntity;
	private JMapper<TurnoDto, Turno> mapperToDTO;
	
	public TurnoServiceImpl(ITurnoRepository turnoRepository) {
		super();
		this.turnoRepository = turnoRepository;
		this.mapperToEntity = new JMapper<>(Turno.class, TurnoDto.class);
		this.mapperToDTO = new JMapper<>(TurnoDto.class, Turno.class);
	}

	@Override
	public List<Turno> getAllTurnos() {		
		return turnoRepository.findAll();
	}

	@Override
	public Turno saveTurno(Turno turno) {
		return turnoRepository.save(turno);
	}

	@Override
	public Turno getTurnoById(Long id) {
		return turnoRepository.findById(id).get();
	}

	@Override
	public Turno updateTurno(Turno turno) {
		return turnoRepository.save(turno);
	}

	@Override
	public void deleteTurnoById(Long id) {
		turnoRepository.deleteById(id);
	}

	@Override
	public Turno mapperToEntity(TurnoDto source) {
		Turno turno = new Turno();
		turno = mapperToEntity.getDestination(source);		
		return turno;
	}

	@Override
	public TurnoDto mapperToDTO(Turno source) {
		TurnoDto turnoDto = new TurnoDto();
		turnoDto = mapperToDTO.getDestination(source);		
		return turnoDto;
	}

	@Override
	public List<TurnoDto> getListDTO(List<Turno> lista) {
		List<TurnoDto> listDTO = new ArrayList<TurnoDto>();
		
		for (Turno turno : getAllTurnos()) {
			listDTO.add(mapperToDTO(turno));
		}
		return listDTO;
	}

}
