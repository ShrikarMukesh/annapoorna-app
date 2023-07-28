package com.annapoorna.enity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Payment {
	@NotBlank(message = "Payment ID cannot be blank")
	private String id;

	@NotBlank(message = "Order ID cannot be blank")
	private String orderId;

	@Positive(message = "Payment amount must be positive")
	private double amount;

	@NotNull(message = "Payment status cannot be null")
	private PaymentStatus status;

	// getters and setters
}
