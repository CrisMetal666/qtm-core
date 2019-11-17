package com.jmtm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "rol", schema = "qtm")
public class Rol {
	
	public final static int ROLE_NEGOCIANTE = 1;
	public final static int ROLE_PROOVEDOR = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	public Rol(Integer id) {
		this.id = id;
	}

}
