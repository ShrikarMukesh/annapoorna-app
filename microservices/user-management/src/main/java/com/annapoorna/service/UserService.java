package com.annapoorna.service;

import java.util.List;

import com.annapoorna.entity.User;

public interface UserService {

	List<User> getAllUsers();

	User getUser(String id);

	User saveUser(User user);

	void deleteUser(String id);
}
