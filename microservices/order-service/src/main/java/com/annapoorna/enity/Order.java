package com.annapoorna.enity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Document(collection = "orders")
@Getter
@Setter
public class Order {
	
    @Id
    private String id;

    @NotBlank(message = "Customer ID cannot be blank")
    private String customerId;

    @Valid
    @NotNull(message = "Order items cannot be null")
    private List<OrderItem> items;

    @Positive(message = "Total cost must be positive")
    private double totalCost;

    @NotNull(message = "Order status cannot be null")
    private OrderStatus orderStatus;

    @Valid
    @NotNull(message = "Payment cannot be null")
    private Payment payment;

    @NotBlank(message = "Delivery details ID cannot be blank")
    private String deliveryDetailsId;

    
}
