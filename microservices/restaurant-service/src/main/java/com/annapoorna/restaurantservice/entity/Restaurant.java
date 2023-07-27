package com.annapoorna.restaurantservice.entity;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "restaurants")
@Getter
@AllArgsConstructor
@Setter
public class Restaurant {
    @Id
    private String id;

    @NotBlank(message = "Restaurant name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Cuisine type is required")
    private String cuisine;

    @NotNull(message = "Address cannot be null")
    @Valid
    private Address address;

    @NotNull(message = "Contact information cannot be null")
    @Valid
    private Contact contact;

    @NotNull(message = "Menu items list cannot be null")
    @Valid
    private List<MenuItem> menu;

    @NotNull(message = "Ratings list cannot be null")
    @Valid
    private List<Rating> ratings;

    @PositiveOrZero(message = "Average rating must be a positive or zero value")
    private double averageRating;

    @NotNull(message = "Created timestamp cannot be null")
    private LocalDateTime createdAt;

    @NotNull(message = "Updated timestamp cannot be null")
    private LocalDateTime updatedAt;

    // Constructors, getters, setters, and other methods (omitted for brevity)
}
