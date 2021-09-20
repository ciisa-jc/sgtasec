package com.jc.sgtasec.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.googlecode.jmapper.annotations.JGlobalMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JGlobalMap
public class ClienteDto {

	private Long id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String email;
	private String rut;
}
