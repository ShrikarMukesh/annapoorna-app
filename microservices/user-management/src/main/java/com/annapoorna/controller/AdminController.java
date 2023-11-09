package com.annapoorna.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annapoorna.entity.User;
import com.annapoorna.service.UserServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private final UserServiceImpl serviceImpl;

	public AdminController(final UserServiceImpl serviceImpl){
		this.serviceImpl = serviceImpl;	
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return serviceImpl.getAllUsers();
	}
}
