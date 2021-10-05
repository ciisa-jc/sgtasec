package com.jc.sgtasec.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jc.sgtasec.model.Llamada;
import com.jc.sgtasec.service.ILlamadaService;
import com.jc.sgtasec.web.dto.LlamadaDto;

@Controller
public class LlamadaController {

	private ILlamadaService llamadaService; 
	
	public LlamadaController(ILlamadaService llamadaService) {
		super();
		this.llamadaService = llamadaService;
	}
//		
//	@GetMapping("/llamadas")
//	public String listLlamadas(Model model) {
//		List<LlamadaDto> listLlamadasDto = new ArrayList<LlamadaDto>();
//		
//		for (Llamada llamada : llamadaService.getAllLlamadas()) {
//			listLlamadasDto.add(llamadaService.mapperToDTO(llamada));
//		}
//		
//		model.addAttribute("llamadas", listLlamadasDto);
//		return "llamadas/llamadas";
//	}
	
	@GetMapping("/llamadas")
	public String listaLlamadasConTurnos(Model model) {
		List<LlamadaDto> listLlamadasDto = new ArrayList<LlamadaDto>();
		
		for (Llamada llamada : llamadaService.listaLlamadasConTurnos()) {
			LlamadaDto llamadaDto = llamadaService.mapperToDTO(llamada);
			
			llamadaDto.setTurno(llamada.getAtencion().getTurno());
			llamadaDto.setTipoAtencion(llamada.getAtencion().getTipoAtencion());
			
			listLlamadasDto.add(llamadaDto);
		}
		
		model.addAttribute("llamadas", listLlamadasDto);
		
		return "llamadas/llamadas";
	}

	@GetMapping("/llamadas/nuevo")
	public String createLlamadaForm(Model model) {
		LlamadaDto llamadaDto = new LlamadaDto();
		model.addAttribute("llamada", llamadaDto);
		return "llamadas/crear_llamada";
	}

	public void saveLlamada(Llamada llamada) {
		llamadaService.saveLlamada(llamada);
	}

	@GetMapping("/llamadas/editar/{id}")
	public String editLlamadaForm(@PathVariable Long id, Model model) {

		LlamadaDto llamadaDto = llamadaService.mapperToDTO(llamadaService.getLlamadaById(id));

		model.addAttribute("llamada", llamadaDto);
		return "llamadas/editar_llamada";
	}

	@PostMapping("/llamadas/{id}")
	public String updateLlamada(@PathVariable Long id, @ModelAttribute("llamada") LlamadaDto llamadaDto, Model model) {

		Llamada existingLlamada = llamadaService.getLlamadaById(id);
		existingLlamada.setAtencion(llamadaDto.getAtencion());
		existingLlamada.setUsuario(llamadaDto.getUsuario());
		existingLlamada.setFechaCreacion(llamadaDto.getFechaCreacion());

		llamadaService.updateLlamada(existingLlamada);
		return "redirect:/llamadas";
	}

	@GetMapping("/llamadas/{id}")
	public String deleteLlamada(@PathVariable Long id) {
		llamadaService.deleteLlamadaById(id);
		return "redirect:/llamadas";
	}
	
}
