package com.sidupadhyayula.socialmediarestapi.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/users/{id}")
	public User retrieveAllUsers(@PathVariable int id){
		return service.findOne(id);
	
	}

}
