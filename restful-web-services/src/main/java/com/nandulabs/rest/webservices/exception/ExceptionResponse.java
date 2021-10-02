package com.nandulabs.rest.webservices.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExceptionResponse {

	private LocalDate timestamp;
	private String message;
	private String details;

}
