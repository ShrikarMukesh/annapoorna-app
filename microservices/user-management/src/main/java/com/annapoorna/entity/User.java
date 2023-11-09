package com.annapoorna.entity;



import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "users")
public class User {

	@Id
	private String id;

	@NotBlank(message = "firstName cannot be blank")
	@Size(min = 3, max = 50, message = "firstName must be between 3 and 50 characters")
	private String firstName;
	
	@Size(min = 3, max = 50, message = "lastName must be between 3 and 50 characters")
	private String lastName;
	
	@Size(min = 3, max = 50, message = "userName must be between 3 and 50 characters")
	private String username;

	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email should be valid")
	private String email;
	
	@Field("roles")
    private Set<Role> roles = new HashSet<>();

	@NotNull(message = "Created timestamp cannot be null")
	private LocalDateTime createdAt;

	@NotNull(message = "Updated timestamp cannot be null")
	private LocalDateTime updatedAt;

	@NotNull(message = "Address cannot be null")
	private Address address;

	private List<Payment> payments;

	private List<Referral> referrals;

	public User() {
		LocalDateTime now = LocalDateTime.now();
		this.createdAt = now;
		this.updatedAt = now;
	}

}
