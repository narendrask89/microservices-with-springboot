package com.nandulabs.rest.webservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	public UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = userDaoService.findOne(id);
		if (user == null)
			throw new UserNotFoundException("Id " + id + " Not Found");
		
		EntityModel<User> entityModel = EntityModel.of(user);
		Link link= WebMvcLinkBuilder.linkTo(
                methodOn(this.getClass()).retrieveAllUsers()).withRel("all-users");
		entityModel.add(link);
		return entityModel;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userDaoService.deleteById(id);
		if (user == null)
			throw new UserNotFoundException("Id " + id + " Not Found");
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
