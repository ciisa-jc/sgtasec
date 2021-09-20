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
import com.jc.sgtasec.model.Atencion;
import com.jc.sgtasec.model.Cliente;
import com.jc.sgtasec.model.TipoAtencion;
import com.jc.sgtasec.model.Turno;
import com.jc.sgtasec.service.IAtencionService;
import com.jc.sgtasec.service.IClienteService;
import com.jc.sgtasec.service.ITipoAtencionService;
import com.jc.sgtasec.web.dto.AtencionDto;
import com.jc.sgtasec.web.dto.ClienteDto;
import com.jc.sgtasec.web.dto.TipoAtencionDto;

@Controller
public class AtencionController {

	private IAtencionService atencionService;
	private IClienteService clienteService;
	private ITipoAtencionService tipoAtencionService;

	public AtencionController(IAtencionService atencionService, 
			IClienteService clienteService, 
			ITipoAtencionService tipoAtencionService) {
		super();
		this.atencionService = atencionService;
		this.clienteService = clienteService;
		this.tipoAtencionService = tipoAtencionService;
		
	}
	
	
	@GetMapping("/atenciones")
	public String listAtenciones(Model model) {
		List<AtencionDto> listAtencionesDto = new ArrayList<AtencionDto>();
		
		for (Atencion atencion : atencionService.getAllAtenciones()) {
			listAtencionesDto.add(atencionService.mapperToDTO(atencion));
		}		
		model.addAttribute("atenciones", listAtencionesDto);		
		return "atenciones/atenciones";
	}

	@GetMapping("/atenciones/nuevo")
	public String createAtencionForm(Model model) {
		AtencionDto atencionDto = new AtencionDto();
		List<Cliente> listClientes = clienteService.getAllClientes();
		List<ClienteDto> listClientesDto = clienteService.getListClientesDTO(listClientes);
		List<TipoAtencion> listTipoAtencion = tipoAtencionService.getAllTipoAtencions();
		List<TipoAtencionDto> listTipoAtencionDto = tipoAtencionService.getListTipoAtencionDTO(listTipoAtencion);		
		model.addAttribute("atencion", atencionDto);
		model.addAttribute("clientes", listClientesDto);
		model.addAttribute("tipoAtenciones", listTipoAtencionDto);
		
		return "atenciones/crear_atencion";
	}

	@PostMapping("/atenciones")
	public void saveAtencion(@ModelAttribute("atencion") AtencionDto atencionDto) {
		Turno turno = new Turno();
		//turno.setTurnoAtencion("C1");
		atencionDto.setTurno(turno);
		atencionDto.setFechaCreacion(LocalDateTime.now());
		
		
		
		System.out.println(atencionDto);
		
		Atencion atencion = atencionService.mapperToEntity(atencionDto);

		atencionService.saveAtencion(atencion);
		//return "redirect:/atenciones";
	}

	@GetMapping("/atenciones/editar/{id}")
	public String editAtencionForm(@PathVariable Long id, Model model) {

		AtencionDto atencionDto = atencionService.mapperToDTO(atencionService.getAtencionById(id));

		model.addAttribute("atencion", atencionDto);
		return "atenciones/editar_atencion";
	}

	@PostMapping("/atenciones/{id}")
	public String updateAtencion(@PathVariable Long id, @ModelAttribute("atencion") AtencionDto atencionDto, Model model) {

		// get Atencion from database by id
		Atencion existingAtencion = atencionService.getAtencionById(id);
		existingAtencion.setCliente(atencionDto.getCliente());
		existingAtencion.setTurno(atencionDto.getTurno());
		existingAtencion.setTipoAtencion(atencionDto.getTipoAtencion());
		existingAtencion.setFechaCreacion(LocalDateTime.now());
	
				
		// save updated Atencion object
		atencionService.updateAtencion(existingAtencion);
		return "redirect:/atenciones";
	}

	@GetMapping("/atenciones/{id}")
	public String deleteAtencion(@PathVariable Long id) {
		atencionService.deleteAtencionById(id);
		return "redirect:/atenciones";
	}
}
