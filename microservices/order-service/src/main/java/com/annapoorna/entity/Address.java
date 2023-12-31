package com.annapoorna.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Address {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
/*
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Data
public class Address {

	@NotBlank(message = "Street cannot be blank")
	private String street;

	@NotBlank(message = "City cannot be blank")
	private String city;

	@NotBlank(message = "State cannot be blank")
	private String state;

	@NotBlank(message = "Country cannot be blank")
	private String country;

	@NotBlank(message = "Postal Code cannot be blank")
	private String postalCode;
}
*/