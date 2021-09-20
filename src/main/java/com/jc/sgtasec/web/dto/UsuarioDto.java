package com.jc.sgtasec.web.dto;

import java.util.Collection;

import com.googlecode.jmapper.annotations.JGlobalMap;
import com.jc.sgtasec.model.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@AllArgsConstructor 
@NoArgsConstructor
@JGlobalMap
public class UsuarioDto {

	private Long id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String email;
	private String password;
	private String rut;
	private Collection<Rol> roles;
	
}
