package com.annapoorna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.annapoorna.entity.User;
import com.annapoorna.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserServiceImpl serviceImpl;

	@Autowired
	public UserController(UserServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return serviceImpl.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable String id) {
		return serviceImpl.getUser(id);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return serviceImpl.saveUser(user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable String id) {
		serviceImpl.deleteUser(id);
	}
}
