package com.annapoorna.menuservice.service;

import com.annapoorna.menuservice.entity.MenuItem;
import com.annapoorna.menuservice.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getAllMenuItems(){
        return menuItemRepository.findAll();
    }
}
