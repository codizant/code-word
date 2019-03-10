package com.krishna.work.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static int userCount = 3;
	/*static {
		users.add(new User(1, "Vedant", new Date()));
		users.add(new User(2, "Pallavi", new Date()));
		users.add(new User(3, "Krishna", new Date()));
	}*/

	
	List<User> users = new ArrayList<User>(Arrays.asList(
			new User(1, "Vedant", new Date()),
			new User(2, "Pallavi", new Date()),
			new User(3, "Krishna", new Date())
			));
	
	public List<User> findAll() {
		return users;
	}

	public User getUser(Integer id){
		System.out.println("-----------UserDaoService::getUser----------------id "+id);
		//users.stream().filter(t->t.getId().equals(id-1)).findFirst().get();
		if(id<users.size()){
			User user = users.get(id-1);
			return user;
		}else{
			return null;
		}
		
	}
	
	public User save(User user) {
		System.out.println("----UserDaoService::save-----Name "+user.getName());
		if (user.getId() == null) { user.setId(++userCount);}
		users.add(user);
		System.out.println("----UserDaoService::save-----Id "+user.getId());
		
		return user;
	}
	
	public User deleteUserById(Integer id){
		Iterator<User> iterator= users.iterator();
			
		while (iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId().equals(id)){
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
	
}
