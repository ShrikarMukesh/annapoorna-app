package com.annapoorna.model;

import com.annapoorna.dto.RestaurantDTO;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    private ObjectId userId;

    private String fullName;

    private String email;

    private String password;

    private String phoneNumber;

    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;

    private List<Order> orders = new ArrayList<>();

    private List<RestaurantDTO> favorites = new ArrayList<>();

    private List<Address> addresses = new ArrayList<>();
}
