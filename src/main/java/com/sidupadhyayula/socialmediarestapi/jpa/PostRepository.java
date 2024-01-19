package com.sidupadhyayula.socialmediarestapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidupadhyayula.socialmediarestapi.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	

}
