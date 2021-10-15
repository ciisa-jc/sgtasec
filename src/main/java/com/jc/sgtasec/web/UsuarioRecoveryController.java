package com.jc.sgtasec.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jc.sgtasec.service.IUsuarioService;
import com.jc.sgtasec.web.dto.UsuarioDto;

@Controller
@RequestMapping("/recuperar")
public class UsuarioRecoveryController {

	private Logger logger = LogManager.getLogger(getClass());
	private IUsuarioService usuarioService;

	public UsuarioRecoveryController(IUsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	@ModelAttribute("usuario")
	public UsuarioDto usuarioDto() {
		return new UsuarioDto();
	}

	@GetMapping
	public String showRecoveryForm() {
		return "recuperar";
	}

	@PostMapping
	public String recoveryUserAccount(@ModelAttribute("usuario") UsuarioDto usuarioDto, Model model) {
		try {

			boolean esRecuperado = usuarioService.recoveryAcces(usuarioDto);

			if (esRecuperado) {
				return "redirect:/recuperar?success";
			}
			return "redirect:/recuperar?error";

		} catch (Exception e) {
			logger.error(e.getMessage());
			model.addAttribute("error", e.getMessage());
			return "error";
		}
	}
}
