package com.jc.sgtasec.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jc.sgtasec.model.Usuario;
import com.jc.sgtasec.service.IUsuarioService;
import com.jc.sgtasec.web.dto.UsuarioDto;

@Controller
public class UsuarioController {
	
	private IUsuarioService usuarioService;	
	
	public UsuarioController(IUsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/usuarios")
	public String listUsuarios(Model model) {
		List<UsuarioDto> listUsuarioDto = new ArrayList<UsuarioDto>();
		
		for (Usuario usuario : usuarioService.getAllUsuarios()) {
			listUsuarioDto.add(usuarioService.mapperToDTO(usuario));
		}
		
		model.addAttribute("usuarios", usuarioService.getAllUsuarios());		
		return "usuarios/usuarios";
	}

	@PostMapping("/usuarios")
	public String saveUsuario(@ModelAttribute("usuario") UsuarioDto usuarioDto) {
		Usuario usuario = usuarioService.mapperToEntity(usuarioDto);

		usuarioService.saveUsuario(usuario);
		return "redirect:/usuarios";
	}

	@GetMapping("/usuarios/editar/{id}")
	public String editUsuarioForm(@PathVariable Long id, Model model) {
		UsuarioDto usuarioDto = usuarioService.mapperToDTO(usuarioService.getUsuarioById(id));
		model.addAttribute("usuario", usuarioDto);
		return "usuarios/editar_usuario";
	}

	@PostMapping("/usuarios/{id}")
	public String updateUsuario(@PathVariable Long id, @ModelAttribute("usuario") UsuarioDto usuarioDto, Model model) {
		
		// Si el usuario es administrador no realiza cambios
		if (usuarioService.esUsuarioAdministrador(id)) {
			return "redirect:/usuarios";
		}

		// get Usuario from database by id
		Usuario existingUsuario = usuarioService.getUsuarioById(id);
		// existingUsuario.setId(id);
		existingUsuario.setNombre(usuarioDto.getNombre());
		existingUsuario.setApellidoPaterno(usuarioDto.getApellidoPaterno());
		existingUsuario.setApellidoMaterno(usuarioDto.getApellidoMaterno());
		existingUsuario.setEmail(usuarioDto.getEmail());
		existingUsuario.setRut(usuarioDto.getRut());
		
		// save updated Usuario object
		usuarioService.updateUsuario(existingUsuario);
		return "redirect:/usuarios";
	}

	@GetMapping("/usuarios/{id}")
	public String deleteUsuario(@PathVariable Long id) {
		
		// Si el usuario es administrador no lo elimina
		if (!usuarioService.esUsuarioAdministrador(id)) {
			usuarioService.deleteUsuarioById(id);
		}
		
		return "redirect:/usuarios";
	}

	

}
