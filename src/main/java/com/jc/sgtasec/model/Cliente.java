package com.jc.sgtasec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.googlecode.jmapper.annotations.JGlobalMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
@JGlobalMap
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellido_paterno", nullable = false)
	private String apellidoPaterno;
	
	@Column(name = "apellido_materno")
	private String apellidoMaterno;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "rut", nullable = false)
	private String rut;

}
