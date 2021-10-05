package com.jc.sgtasec.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jc.sgtasec.model.Atencion;
import com.jc.sgtasec.model.Llamada;
import com.jc.sgtasec.model.Turno;
import com.jc.sgtasec.service.IAtencionService;
import com.jc.sgtasec.service.IClienteService;
import com.jc.sgtasec.service.ILlamadaService;
import com.jc.sgtasec.service.ITipoAtencionService;
import com.jc.sgtasec.service.ITurnoService;
import com.jc.sgtasec.service.IUsuarioService;
import com.jc.sgtasec.web.dto.AtencionDto;
import com.jc.sgtasec.web.dto.ClienteDto;
import com.jc.sgtasec.web.dto.TipoAtencionDto;

@Controller
public class AtencionController {
	
	private Authentication auth;
	
	private IAtencionService atencionService;
	private IClienteService clienteService;
	private ITipoAtencionService tipoAtencionService;
	private ITurnoService turnoService;
	private ILlamadaService llamadaService;
	private IUsuarioService usuarioService;

	public AtencionController(IAtencionService atencionService, 
			IClienteService clienteService, 
			ITipoAtencionService tipoAtencionService, 
			ITurnoService turnoService,
			ILlamadaService llamadaService,
			IUsuarioService usuarioService) {
		super();
		this.atencionService = atencionService;
		this.clienteService = clienteService;
		this.tipoAtencionService = tipoAtencionService;
		this.turnoService = turnoService;
		this.llamadaService = llamadaService;
		this.usuarioService = usuarioService;	
	}
	
	
	@GetMapping("/atenciones")
	public String listAtenciones(Model model) {
		
		List<AtencionDto> listAtencionesDto = new ArrayList<AtencionDto>();
		
		for (Atencion atencion : atencionService.getAtencionesConCantidadDeLlamadas()) {
			listAtencionesDto.add(atencionService.mapperToDTO(atencion));
		}		
		model.addAttribute("atenciones", listAtencionesDto);		
		return "atenciones/atenciones";
	}

	@GetMapping("/atenciones/nuevo")
	public String createAtencionForm(Model model) {
		AtencionDto atencionDto = new AtencionDto();
		List<ClienteDto> listClientesDto = clienteService.getListClientesDTO(clienteService.getAllClientes());
		List<TipoAtencionDto> listTipoAtencionDto = tipoAtencionService.getListTipoAtencionDTO(tipoAtencionService.getAllTipoAtencions());		
		model.addAttribute("atencion", atencionDto);
		model.addAttribute("clientes", listClientesDto);
		model.addAttribute("tipoAtenciones", listTipoAtencionDto);		
		return "atenciones/crear_atencion";
	}

	@PostMapping("/atenciones")
	public String saveAtencion(@ModelAttribute("atencion") AtencionDto atencionDto) {
		Turno turno = new Turno();
		turno = turnoService.getTurnoDisponible();		
		atencionDto.setTurno(turno);
		atencionDto.setFechaCreacion(LocalDateTime.now());	
		Atencion atencion = atencionService.mapperToEntity(atencionDto);
		atencionService.saveAtencion(atencion);
		// Marcar el turno 1 En atención, -- 0 TURNO DISPONIBLE, 1 TURNO EN ATENCIÓN, 2 TURNO ATENDIDO
		turno.setEstado(1);
		turnoService.saveTurno(turno);

		return "redirect:/atenciones";
	}

	@GetMapping("/atenciones/{id}")
	public String deleteAtencion(@PathVariable Long id) {
		
		Atencion existingAtencion = atencionService.getAtencionById(id);
		List<Llamada> llamadas = llamadaService.findByAtencion(existingAtencion);

		for (Llamada llamada : llamadas) {
			if (llamada.getAtencion().getId() == id) {
				llamadaService.deleteLlamadaById(llamada.getId());
			}			
		}

		atencionService.deleteAtencionById(id);
		return "redirect:/atenciones";
	}

	@GetMapping("/atenciones/llamar/{id}")
	public String realizarLlamadoParaAtencion(@PathVariable Long id) {
		Atencion existingAtencion = atencionService.getAtencionById(id);

		Llamada llamada = new Llamada();
		llamada.setFechaCreacion(LocalDateTime.now());
		llamada.setAtencion(existingAtencion);		
		this.auth = SecurityContextHolder.getContext().getAuthentication();
		llamada.setUsuario(usuarioService.getUsuarioByEmail(auth.getName()));
		llamadaService.saveLlamada(llamada);
	
		return "redirect:/atenciones";
	}
}
