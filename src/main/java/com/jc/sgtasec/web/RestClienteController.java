package com.jc.sgtasec.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.sgtasec.model.Cliente;
import com.jc.sgtasec.service.IClienteService;
import com.jc.sgtasec.web.dto.ClienteDto;

@RestController
public class RestClienteController {
	
	private IClienteService clienteService;

	public RestClienteController(IClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}

	@GetMapping("/clientes/json")
	public List<ClienteDto> listClientes() {
		List<ClienteDto> listClientesDto = new ArrayList<ClienteDto>();
		
		for (Cliente cliente : clienteService.getAllClientes()) {
			listClientesDto.add(clienteService.mapperToDTO(cliente));
		}
		
		return listClientesDto;
	
	}
	
	@GetMapping("/clientes/json2")
	public String listClientes2() {
		String texto ="[{\"id\":11,\"nombre\":\"Carlos\",\"apellidoPaterno\":\"Perez\",\"apellidoMaterno\":\"Carreara\",\"email\":\"acarrera@mail.com\",\"rut\":\"22222222-2\"}]";

		return texto;
	
	}
}
