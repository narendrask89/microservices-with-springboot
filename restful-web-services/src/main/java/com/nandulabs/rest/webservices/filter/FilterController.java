package com.nandulabs.rest.webservices.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

	@GetMapping("/filtering")
	public UserResponse getUserResponse() {
		return UserResponse.builder().firstName("Narendra").lastName("Sahu").username("test").password("test").build();
	}
}
