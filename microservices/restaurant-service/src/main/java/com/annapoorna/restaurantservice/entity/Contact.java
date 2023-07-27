package com.annapoorna.restaurantservice.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
@Getter
@AllArgsConstructor
@Setter
@ToString
public class Contact {
    @NotBlank(message = "Phone number is required")
    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    // Constructors, getters, setters, and other methods (omitted for brevity)
}
