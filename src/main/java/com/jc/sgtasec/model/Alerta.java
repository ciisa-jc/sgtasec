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
@Table(name = "alertas")
@JGlobalMap
public class Alerta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "color", unique = true, nullable = false, length = 50)
	private String color;

	@Column(name = "duracion", nullable = false, length = 4)
	private Integer duracion;

	@Column(name = "descripcion", nullable = false, length = 255)
	private String descripcion;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;
}
