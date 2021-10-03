package com.nandulabs.rest.webservices.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(value = { "username" })
public class UserResponse {

	private String username;

	@JsonIgnore
	private String password;

	private String firstName;

	private String lastName;
}
