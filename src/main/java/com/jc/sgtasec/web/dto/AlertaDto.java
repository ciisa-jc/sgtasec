package com.jc.sgtasec.web.dto;

import java.time.LocalDateTime;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JGlobalMap
public class AlertaDto {

	private Long id;
	private String color;
	private Integer duracionDesde;
	private Integer duracionHasta;
	private String descripcion;
	private LocalDateTime fechaCreacion;
}
