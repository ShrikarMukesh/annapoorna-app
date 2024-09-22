package com.annapoorna.menuservice.service;

import com.annapoorna.menuservice.entity.Menu;
import com.annapoorna.menuservice.repository.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenus(){
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuByMenuId(String menuId){
        return menuRepository.findById(menuId);
    }

    public Optional<Menu> getMenuByRestaurantId(String restaurantId){
        return menuRepository.findMenuByRestaurantId(restaurantId);
    }

    public Optional<Menu> getMenuByCategory(String category){
        return menuRepository.findMenuByCategory(category);
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(String menuId, Menu updatedMenu){

        Menu existingMenu=menuRepository.findById(menuId).orElseThrow();

        existingMenu.setMenuId(updatedMenu.getMenuId());
        existingMenu.setRestaurantId(updatedMenu.getRestaurantId());
        existingMenu.setItems(updatedMenu.getItems());
        existingMenu.setCategory(updatedMenu.getCategory());
        return menuRepository.save(existingMenu);

    }

    public void deleteMenu(String menuId){
        menuRepository.deleteById(menuId);
    }

}
