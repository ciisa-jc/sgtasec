package com.jc.sgtasec.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@JGlobalMap
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@Column(name = "apellido_paterno")
	private String apellidoPaterno;
	@Column(name = "apellido_materno")
	private String apellidoMaterno;
	private String email;
	private String password;
	private String rut;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
   	private Collection<Rol> roles;

	public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String email, String password,
			String rut, Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.email = email;
		this.password = password;
		this.rut = rut;
		this.roles = roles;
	}

}
