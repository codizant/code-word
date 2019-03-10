package com.krishna.work.user;

public class UserDaoServiceTest {

	
	
	public static void main(String[] args){
		UserDaoService userDaoService = new UserDaoService();
		User user = userDaoService.getUser(2);
		System.out.println("user=>"+user.toString());
	}
}
