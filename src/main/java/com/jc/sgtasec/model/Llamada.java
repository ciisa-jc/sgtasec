package com.jc.sgtasec.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "llamadas")
@JGlobalMap
public class Llamada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "id_atencion", referencedColumnName = "id")
	private Atencion atencion;
	
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
    Date fechaCreacion;		

}
