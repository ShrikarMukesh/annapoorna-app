package com.annapoorna.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.annapoorna.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findByEmail(String email);
	// Additional query methods can be defined here

	Optional<User> findByFirstName(String firstName);

	org.springframework.security.core.userdetails.User findByUsername(String username);
}
