package com.jc.sgtasec.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jc.sgtasec.model.Turno;
import com.jc.sgtasec.service.ITurnoService;
import com.jc.sgtasec.web.dto.TurnoDto;

@Controller
public class TurnoController {

	private ITurnoService turnoService;
	
	public TurnoController(ITurnoService turnoService) {
		super();
		this.turnoService = turnoService;
	}
	
	@GetMapping("/turnos")
	public String listTurnos(Model model) {
		List<TurnoDto> listTurnoDto  = new ArrayList<TurnoDto>();
		
		for (Turno turno : turnoService.getAllTurnos()) {
			listTurnoDto.add(turnoService.mapperToDTO(turno));
		}
		
		model.addAttribute("turnos", listTurnoDto);
		return "turnos/turnos";
	}
	
	@GetMapping("/turnos/nuevo")
	public String createTurnoForm(Model model) {
		TurnoDto turnoDto = new TurnoDto();
		model.addAttribute("turno", turnoDto);
		return "turnos/crear_turno";
	}
	
	@PostMapping("/turnos")
	public String saveTurno(@ModelAttribute("turno") TurnoDto turnoDto) {
		
		Turno turno = turnoService.mapperToEntity(turnoDto);

		turnoService.saveTurno(turno);
		return "redirect:/turnos";
	}
	
	@GetMapping("/turnos/editar/{id}")
	public String editTurnoForm(@PathVariable Long id, Model model) {
		
		TurnoDto turnoDto = turnoService.mapperToDTO(turnoService.getTurnoById(id));

		model.addAttribute("turno", turnoDto);
		return "turnos/editar_turno";
	}
	
	@PostMapping("/turnos/{id}")
	public String updateTurno(@PathVariable Long id, @ModelAttribute("turno") TurnoDto turnoDto, Model model) {
		
		Turno existingTurno = turnoService.getTurnoById(id);
		existingTurno.setTurnoAtencion(turnoDto.getTurnoAtencion());
		existingTurno.setEstado(turnoDto.getEstado());
		
		turnoService.updateTurno(existingTurno);		
		return "redirect:/turnos";
	}
		
	@GetMapping("/turnos/{id}")
	public String deleteTurno(@PathVariable Long id) {
		turnoService.deleteTurnoById(id);
		return "redirect:/turnos";
	}
}
