package com.sidupadhyayula.socialmediarestapi.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
	
	
	// create a list to add users
	
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount= 0;
	
	static {
		users.add(new User(++usersCount, "Sid", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Lee", LocalDate.now().minusYears(23)));
		users.add(new User(++usersCount, "Mark", LocalDate.now().minusYears(29)));
		users.add(new User(++usersCount, "JAck", LocalDate.now().minusYears(35)));
	}
	
	//return list
	
	public List<User> findAll(){
		return users;
	}
	
	/*
	 * public User findOne(int id) { Predicate<? super User> predicate = user ->
	 * user.getId().equals(id); return
	 * users.stream().filter(predicate).findFirst().get(); }
	 */
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	

}
