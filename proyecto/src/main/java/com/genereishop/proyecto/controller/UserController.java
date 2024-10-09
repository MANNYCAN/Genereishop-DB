package com.genereishop.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genereishop.proyecto.dto.ChangePassword;
import com.genereishop.proyecto.modelo.User;
import com.genereishop.proyecto.service.UserService;

@RestController
@RequestMapping(path="/api/users/")
public class UserController {
	
	private final UserService userservice;
	@Autowired
	public UserController(UserService userservice) {
		this.userservice = userservice;
	}//constructor 
	
	@GetMapping
	public List<User> getUsers(){
		return userservice.getAllUsers();
	}//Allusers
	
	@GetMapping(path="{usId}")
	public User getUser(@PathVariable("usId") Long usId) {
		return userservice.getUser(usId);
	}//getuser
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userservice.addUser(user);
	}//Post
	
	@DeleteMapping(path="{usId}")
	public User deleteUser(@PathVariable("usId") Long usId) {
		return userservice.deleteUser(usId);
	}//DeleteUser
	
	@PutMapping(path="{usId}")
	public User updateUser(@RequestBody ChangePassword changepassword,
			@PathVariable("usId") Long usId,
			@RequestParam(required=false) String userName,
			@RequestParam(required=false) Long userPhone
			) {
		return userservice.updateUser(usId, changepassword, userName, userPhone);
	}//UpdateUser
	
	
}//class controller 
