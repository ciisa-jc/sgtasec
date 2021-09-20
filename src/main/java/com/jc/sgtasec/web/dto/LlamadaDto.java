package com.jc.sgtasec.web.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.googlecode.jmapper.annotations.JGlobalMap;
import com.jc.sgtasec.model.Atencion;
import com.jc.sgtasec.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JGlobalMap
public class LlamadaDto {
	
	private Long id;
	private Usuario usuario;
	private Atencion atencion;
	
	@Temporal(TemporalType.DATE)
    Date fechaCreacion;	

}
