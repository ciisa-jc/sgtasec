package com.jc.sgtasec.web.dto;

import java.time.LocalDateTime;
import com.googlecode.jmapper.annotations.JGlobalMap;
import com.jc.sgtasec.model.Cliente;
import com.jc.sgtasec.model.TipoAtencion;
import com.jc.sgtasec.model.Turno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JGlobalMap
public class AtencionDto {
	
	private Long id;
	private Turno turno;
	private Cliente cliente;
	private TipoAtencion tipoAtencion;
	private LocalDateTime fechaCreacion;	

}
