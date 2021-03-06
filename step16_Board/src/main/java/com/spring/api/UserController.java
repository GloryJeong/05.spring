package com.spring.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.UserDTO;
import com.spring.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {
	
	private final UserServiceImpl userService;
	
	@GetMapping(value = "/user/{userEmail}")
	public UserDTO getUserByUserEmail(@PathVariable String userEmail) {
		System.out.println(userEmail);
		UserDTO user =userService.getUserByUserEmail(userEmail);
		System.out.println(user);
		return user;
	}
	
	@PostMapping(value="/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertUser(@RequestBody UserDTO userDTO) {
		System.out.println(userDTO);
		userService.insertUser(userDTO);
	}
	
	
}
