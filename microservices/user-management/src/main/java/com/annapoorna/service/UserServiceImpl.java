package com.annapoorna.service;

import org.springframework.stereotype.Service;

import com.annapoorna.entity.User;
import com.annapoorna.exception.DuplicateEmailException;
import com.annapoorna.exception.DuplicateUserNameException;
import com.annapoorna.exception.UserNotFoundException;
import com.annapoorna.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
	}


	@Override
	public User saveUser(User user) {
		// Check if the email already exists in the database
		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new DuplicateEmailException("Email already in use: " + user.getEmail());
		}

		// Check if the user name already exists in the database
		if (userRepository.findByFirstName(user.getFirstName()).isPresent()) {
			throw new DuplicateUserNameException("Username already in use: " + user.getFirstName());
		}

		// Save the user and return it
		return userRepository.save(user);
	}


	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
}
