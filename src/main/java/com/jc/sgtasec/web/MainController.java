package com.jc.sgtasec.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	Logger logger = LogManager.getLogger(getClass());
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {		
		 logger.info("Ingreso a pagina index ");
		return "index";
	}
}
