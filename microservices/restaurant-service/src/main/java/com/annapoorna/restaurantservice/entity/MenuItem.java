package com.annapoorna.restaurantservice.entity;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Positive;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class MenuItem {
    @NotBlank(message = "Menu item name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @Positive(message = "Price must be a positive value")
    private double price;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Image URL is required")
    private String image;

    // Constructors, getters, setters, and other methods (omitted for brevity)
}
