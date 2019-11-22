package com.jmtm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario", schema = "qtm")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "identificacion")
	private String identificacion;

	@Column(name = "clave", updatable = false)
	private String clave;

	@Column(name = "celular")
	private String celular;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rol_id")
	private Rol rol;
	
	

}
