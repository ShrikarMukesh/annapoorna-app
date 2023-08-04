package com.annapoorna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.annapoorna.dto.AuthRequest;
import com.annapoorna.entity.Customer;
import com.annapoorna.service.CustomerServiceImpl;
import com.annapoorna.service.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private JwtService jwtService;

	private final CustomerServiceImpl customerService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	public CustomerController(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}

	@PostMapping("/register")
	public ResponseEntity<Customer> register(@Valid @RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.register(customer));
	}

	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		return ResponseEntity.ok(customerService.getAllCustomer());
	}

	@GetMapping("/{email}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Customer> findByEmail(@PathVariable String email) {
		return ResponseEntity.ok(customerService.findByEmail(email));
	}

	@PutMapping("/update")
	public ResponseEntity<Customer> update(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.update(customer));
	}

	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}


	}
}
