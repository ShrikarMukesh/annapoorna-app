package com.annapoorna.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.annapoorna.entity.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
	List<Order> findByCustomerId(String customerId);
}
