package com.annapoorna.menuservice.repository;

import com.annapoorna.menuservice.entity.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends MongoRepository<MenuItem, Long> {

}
