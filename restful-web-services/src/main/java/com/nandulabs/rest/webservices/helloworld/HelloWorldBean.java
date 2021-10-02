package com.nandulabs.rest.webservices.helloworld;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HelloWorldBean {

	private String message;
}
