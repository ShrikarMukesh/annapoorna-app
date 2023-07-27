package com.annapoorna.restaurantservice.entity;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.PositiveOrZero;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Rating {
    @NotBlank(message = "User ID is required")
    private String userId;

    @PositiveOrZero(message = "Rating must be a positive value or zero")
    private double rating;

    private String comment;

    // Constructors, getters, setters, and other methods (omitted for brevity)
}
