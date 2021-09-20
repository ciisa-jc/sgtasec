package com.jc.sgtasec.web.dto;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JGlobalMap
public class TurnoDto {

	private Long id;
	private String turnoAtencion;
	private int estado;
}
