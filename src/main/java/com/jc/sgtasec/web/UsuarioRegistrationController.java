package com.jc.sgtasec.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jc.sgtasec.service.IUsuarioService;
import com.jc.sgtasec.web.dto.UsuarioDto;

@Controller
@RequestMapping("/registro")
public class UsuarioRegistrationController {

	private IUsuarioService usuarioService;

	public UsuarioRegistrationController(IUsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@ModelAttribute("usuario")
	public UsuarioDto usuarioDto() {
		return new UsuarioDto();
	} 
	
	@GetMapping	
	public String showRegistrationForm() {
		return "registro";
	}
		
	@PostMapping
	public String registerUserAccount(@ModelAttribute("usuario") UsuarioDto usuarioDto) {
		usuarioService.save(usuarioDto);		
		return "redirect:/registro?success";
	}	
}
