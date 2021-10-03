package com.nandulabs.rest.webservices.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilterController {

	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue getUserResponse() {
		UserDynamicResponse userResponse = UserDynamicResponse.builder().firstName("Narendra").lastName("Sahu")
				.username("test").password("test").build();

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userResponse);
		SimpleBeanPropertyFilter propertyzFilter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName");
		FilterProvider filters = new SimpleFilterProvider().addFilter("dynamic-filter", propertyzFilter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}

	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue getUserListResponse() {
		List<UserDynamicResponse> list = Arrays.asList(
				UserDynamicResponse.builder().firstName("Narendra").lastName("Sahu").username("test").password("test")
						.build(),
				UserDynamicResponse.builder().firstName("Santosh").lastName("Sahu").username("test").password("test")
						.build());

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter propertyzFilter = SimpleBeanPropertyFilter.filterOutAllExcept("username", "firstName", "lastName");
		FilterProvider filters = new SimpleFilterProvider().addFilter("dynamic-filter", propertyzFilter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
}
