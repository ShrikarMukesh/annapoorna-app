package com.annapoorna.menuservice.repository;

import com.annapoorna.menuservice.entity.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends MongoRepository<Menu,String> {

    Optional<Menu> findMenuByCategory(String category);
    Optional<Menu> findMenuByRestaurantId(String restaurantId);
}
