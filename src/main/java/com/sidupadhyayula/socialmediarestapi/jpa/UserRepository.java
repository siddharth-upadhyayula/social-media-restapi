package com.sidupadhyayula.socialmediarestapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidupadhyayula.socialmediarestapi.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	

}
