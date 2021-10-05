package com.jc.sgtasec.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jc.sgtasec.model.Alerta;
import com.jc.sgtasec.service.IAlertaService;
import com.jc.sgtasec.web.dto.AlertaDto;

@Controller
public class AlertaController {
	
	private IAlertaService alertaService;
	
	
	public AlertaController(IAlertaService alertaService) {
		super();
		this.alertaService = alertaService;
	}
	
	@GetMapping("/alertas")
	public String listAlertas(Model model) {		
		List<AlertaDto> listAlertaDtos = new ArrayList<AlertaDto>();
		
		for (Alerta alerta : alertaService.getAllAlertas()) {
			listAlertaDtos.add(alertaService.mapperToDTO(alerta));
		}
		
		model.addAttribute("alertas", listAlertaDtos);
		return "alertas/alertas";		
	}
	
	@GetMapping("/alertas/nuevo")
	public String createAlertaForm(Model model) {
		AlertaDto alertaDto = new AlertaDto();
		model.addAttribute("alerta", alertaDto);
		return "alertas/crear_alerta";
	}
		
	@PostMapping("/alertas")
	public String saveAlerta(@ModelAttribute("alerta") AlertaDto alertaDto) {
		Alerta alerta = alertaService.mapperToEntity(alertaDto);
		alerta.setFechaCreacion(LocalDateTime.now());
		
		alertaService.saveAlerta(alerta);	
		return "redirect:/alertas";		
	}
	
	@GetMapping("/alertas/editar/{id}")
	public String editAlertaForm(@PathVariable Long id, Model model) {
		AlertaDto alertaDto = alertaService.mapperToDTO(alertaService.getAlertaById(id));
		
		model.addAttribute("alerta", alertaDto);
		return "alertas/editar_alerta";
	}

	@PostMapping("/alertas/{id}")
	public String updateAlerta(@PathVariable Long id,
			@ModelAttribute("alerta") AlertaDto alertaDto,
			Model model) {
		
		// get Alerta from database by id
		Alerta existingAlerta = alertaService.getAlertaById(id);
		//existingAlerta.setId(id);
		existingAlerta.setColor(alertaDto.getColor());
		existingAlerta.setDuracionDesde(alertaDto.getDuracionDesde());
		existingAlerta.setDuracionHasta(alertaDto.getDuracionHasta());
		existingAlerta.setDescripcion(alertaDto.getDescripcion());
		existingAlerta.setFechaCreacion(LocalDateTime.now());
				
		// save updated Alerta object
		alertaService.updateAlerta(existingAlerta);
		return "redirect:/alertas";		
	}
			 	
	@GetMapping("/alertas/{id}")
	public String deleteAlerta(@PathVariable Long id) {
		alertaService.deleteAlertaById(id);
		return "redirect:/alertas";
	}	
	

}
