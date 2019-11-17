package com.jmtm.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExceptionResponse {

	private LocalDate timestamp;
	private String message;
	private String detail;

	public ExceptionResponse(LocalDate timestamp, String message, String detail) {
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
	}

}
