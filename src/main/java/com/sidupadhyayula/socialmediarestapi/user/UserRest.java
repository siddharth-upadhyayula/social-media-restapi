package com.sidupadhyayula.socialmediarestapi.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserRest {
	
	
	private UserDaoService service;
	
	public UserRest(UserDaoService service) {
		this.service = service;
	}
	
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	
	}
	
	/*
	 * @GetMapping("/users/{id}") public User retrieveAllUsers(@PathVariable int
	 * id){ return service.findOne(id);
	 * 
	 * }
	 */
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();   
		
		return ResponseEntity.created(location).build();
		
	}

}
