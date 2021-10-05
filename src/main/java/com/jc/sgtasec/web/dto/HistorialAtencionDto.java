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
public class HistorialAtencionDto {

	private Long id;
	private Long idAtencion;
	private LocalDateTime fechaCreacionAtencion;
	private String apellidoPaternoCliente;
	private String apellidoMaternoCliente;
	private String nombreCliente;
	private String emailCliente;
	private String rutCliente;
	private String nombreTipoAtencion;
	private int tiempoAtencion;
	private String turnoAtencion;
	private LocalDateTime fechaCreacionLlamada;
}
