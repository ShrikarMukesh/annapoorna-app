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
