package com.annapoorna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annapoorna.entity.Customer;
import com.annapoorna.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer register(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> getAllCustomer( ) {
		return customerRepository.findAll();
	}

	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}
}
