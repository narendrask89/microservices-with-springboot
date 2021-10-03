package com.nandulabs.rest.webservices.filter;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonFilter("dynamic-filter")
public class UserDynamicResponse {

	private String username;

	private String password;

	private String firstName;

	private String lastName;
}
