package com.jc.sgtasec.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jc.sgtasec.model.TipoAtencion;
import com.jc.sgtasec.service.ITipoAtencionService;
import com.jc.sgtasec.web.dto.TipoAtencionDto;

@Controller
public class TipoAtencionController {

	private ITipoAtencionService tipoAtencionService;

	public TipoAtencionController(ITipoAtencionService tipoAtencionService) {
		super();
		this.tipoAtencionService = tipoAtencionService;
	}

	@GetMapping("/tipo_atencion")
	public String listTipoAtencion(Model model) {
		List<TipoAtencionDto> listTipoAtencionDto = new ArrayList<TipoAtencionDto>();
		
		for (TipoAtencion tipoAtencion : tipoAtencionService.getAllTipoAtencions()) {
			listTipoAtencionDto.add(tipoAtencionService.mapperToDTO(tipoAtencion));
		}
				
		model.addAttribute("tipo_atenciones", listTipoAtencionDto);
		return "tipo_atencion/tipo_atenciones";
	}

	@GetMapping("/tipo_atencion/nuevo")
	public String createTipoAtencionForm(Model model) {
		TipoAtencionDto tipoAtencionDto = new TipoAtencionDto();
		model.addAttribute("tipoAtencion", tipoAtencionDto);
		return "tipo_atencion/crear_tipo_atencion";
	}

	@PostMapping("/tipo_atencion")
	public String saveTipoAtencion(@ModelAttribute("tipoAtencion") TipoAtencionDto tipoAtencionDto) {
		
		TipoAtencion tipoAtencion = tipoAtencionService.mapperToEntity(tipoAtencionDto);

		tipoAtencionService.saveTipoAtencion(tipoAtencion);
		return "redirect:/tipo_atencion";
	}

	@GetMapping("/tipo_atencion/editar/{id}")
	public String editTipoAtencionForm(@PathVariable Long id, Model model) {
		TipoAtencionDto tipoAtencionDto = tipoAtencionService.mapperToDTO(tipoAtencionService.getTipoAtencionById(id));
		
		model.addAttribute("tipoAtencion", tipoAtencionDto);
		return "tipo_atencion/editar_tipo_atencion";
	}

	@PostMapping("/tipo_atencion/{id}")
	public String updateTipoAtencion(@PathVariable Long id, @ModelAttribute("tipo_atencion") TipoAtencionDto tipoAtencionDto, Model model) {

		// get from database by id
		TipoAtencion existingTipoAtencion = tipoAtencionService.getTipoAtencionById(id);
		existingTipoAtencion.setNombre(tipoAtencionDto.getNombre());
		existingTipoAtencion.setTiempoAtencion(tipoAtencionDto.getTiempoAtencion());		
		// save updated object
		tipoAtencionService.updateTipoAtencion(existingTipoAtencion);
		return "redirect:/tipo_atencion";
	}

	@GetMapping("/tipo_atencion/{id}")
	public String deleteTipoAtencion(@PathVariable Long id) {
		tipoAtencionService.deleteTipoAtencionById(id);
		return "redirect:/tipo_atencion";
	}
}
