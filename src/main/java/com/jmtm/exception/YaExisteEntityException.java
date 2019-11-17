package com.jmtm.exception;

public class YaExisteEntityException extends RuntimeException {

	private static final long serialVersionUID = -5542539026311753320L;
	
	public YaExisteEntityException(String mensaje) {
		super(mensaje);
	}

}
