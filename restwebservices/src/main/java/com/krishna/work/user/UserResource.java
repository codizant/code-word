package com.krishna.work.user;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;




@RestController
public class UserResource {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserDaoService userDaoService;
	
	
	@GetMapping(path="/users")
	public List<User> retriveAllUser(){
		System.out.println("----UserResource::retriveAllUser-----");
		return userDaoService.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User retriveUser(@PathVariable int id){
		System.out.println("----UserResource::retriveUser-----id "+id);
		User user =userDaoService.getUser(id);
		if(user==null){
			throw new UserNotFoundException("User Not found for Id:="+id);
		}
		return user;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		System.out.println("----UserResource::createUser-----Name "+user.getName());
		User saveUser=	userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}").buildAndExpand(saveUser.getId()).toUri();
			
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping(path="/users/{id}")
	public User deleteUser(@PathVariable int id){
		System.out.println("----UserResource::deleteUser-----id "+id);
		User user =userDaoService.deleteUserById(id);
		if(user==null){
			throw new UserNotFoundException("User Not found for Id:="+id);
		}
		return user;
	}
	
	//I18n
	@GetMapping(path = "/hello-world-i18n")
	public String helloI18n() {
		System.out.println("----UserResource::helloI18n-----");		
		return messageSource.getMessage("morning.message", null,
				LocaleContextHolder.getLocale());
		
	}

}
