package com.jc.sgtasec.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historial_atenciones")
@JGlobalMap
public class HistorialAtencion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name = "id_atencion")
	private Long idAtencion; 
	
	@Column(name = "fecha_creacion_atencion")
	private LocalDateTime fechaCreacionAtencion; 
	
	@Column(name = "apellido_paterno_cliente")
	private String apellidoPaternoCliente; 
	
	@Column(name = "apellido_materno_cliente")
	private String apellidoMaternoCliente; 
	
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	
	@Column(name = "email_cliente")
	private String emailCliente;
	
	@Column(name = "rut_cliente")
	private String rutCliente; 
	
	@Column(name = "nombre_tipo_atencion")
	private String nombreTipoAtencion; 
	
	@Column(name = "tiempo_atencion")
	private int tiempoAtencion; 
	
	@Column(name = "turno_atencion")
	private String turnoAtencion; 
	
	@Column(name = "fecha_creacion_llamada")
	private LocalDateTime fechaCreacionLlamada; 

}
