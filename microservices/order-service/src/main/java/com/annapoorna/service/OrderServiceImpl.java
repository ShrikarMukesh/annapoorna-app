package com.annapoorna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annapoorna.enity.Order;
import com.annapoorna.enity.OrderStatus;
import com.annapoorna.exception.ResourceNotFoundException;
import com.annapoorna.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order createOrder(Order order) {
		log.info("Creating new order for customer id: {}", order.getCustomerId());

		// Business logic: calculating total cost
		double totalCost = order.getItems().stream()
				.mapToDouble(item -> item.getProductPrice() * item.getQuantity())
				.sum();
		order.setTotalCost(totalCost);

		// Basic validation: total cost should be positive
		if (order.getTotalCost() <= 0) {
			throw new IllegalArgumentException("Total cost must be positive.");
		}

		// Basic validation: order status should be 'PLACED' for new orders
		if (order.getOrderStatus() != OrderStatus.PLACED) {
			throw new IllegalArgumentException("Order status for new orders must be 'PLACED'.");
		}

		// Basic validation: there should be at least one item in the order
		if (order.getItems().isEmpty()) {
			throw new IllegalArgumentException("Order should have at least one item.");
		}

		return orderRepository.save(order);
	}



	@Override
	public List<Order> findAllOrders() {
		log.info("Fetching all orders");
		return orderRepository.findAll();
	}

	@Override
	public Order findOrderById(String id) {
		log.info("Fetching order with id: {}", id);
		return orderRepository.findById(id)
				.orElseThrow(() -> {
					log.error("Order not found with id: {}", id);
					return new ResourceNotFoundException("Order not found with id: " + id);
				});
	}

	@Override
	public List<Order> findOrdersByCustomerId(String customerId) {
		log.info("Fetching orders for customer id: {}", customerId);
		return orderRepository.findByCustomerId(customerId);
	}

	@Override
	public Order updateOrder(String id, Order updatedOrder) {
		log.info("Updating order with id: {}", id);

		return orderRepository.findById(id)
				.map(order -> {
					// Update the order fields here:
					order.setCustomerId(updatedOrder.getCustomerId());
					order.setItems(updatedOrder.getItems());
					order.setOrderStatus(updatedOrder.getOrderStatus());
					order.setPayment(updatedOrder.getPayment());
					order.setDeliveryDetailsId(updatedOrder.getDeliveryDetailsId());

					// Recalculate the total cost in case the items have changed
					double totalCost = order.getItems().stream()
							.mapToDouble(item -> item.getProductPrice() * item.getQuantity())
							.sum();
					order.setTotalCost(totalCost);

					return orderRepository.save(order);
				})
				.orElseThrow(() -> new IllegalArgumentException("Order with id " + id + " not found"));
	}

	@Override
	public void deleteOrder(String id) {
		log.info("Deleting order with id: {}", id);
		if (!orderRepository.existsById(id)) {
			log.error("Order not found with id: {}", id);
			throw new ResourceNotFoundException("Order not found with id: " + id);
		}
		orderRepository.deleteById(id);
	}


}

