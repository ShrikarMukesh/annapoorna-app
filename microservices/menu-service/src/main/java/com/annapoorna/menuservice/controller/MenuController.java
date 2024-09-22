package com.annapoorna.menuservice.controller;

import com.annapoorna.menuservice.entity.Menu;
import com.annapoorna.menuservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/allMenus")
    public List<Menu> getAllMenus(){
        //log.info("MenuController: getAllMenus ");
        return menuService.getAllMenus();
    }

    @GetMapping("/id")
    public Optional<Menu> getMenuByMenuId(@PathVariable  String menuId){
        return menuService.getMenuByMenuId(menuId);
    }

    @GetMapping("/category")
    public Optional<Menu> getMenuByCategory(@PathVariable String category){
        return menuService.getMenuByCategory(category);
    }

    @PostMapping("/addMenu")
    public Menu createMenu(@RequestBody Menu menu) {
      //  log.info("MenuController: getAllMenus ");
       // Menu createdMenu = menuService.createMenu(menu);
        //return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
        return menuService.createMenu(menu);
    }

    @PutMapping("/id")
    public Menu updateMenu(@PathVariable String menuId, @RequestBody Menu updatedMenu){
        return menuService.updateMenu(menuId,updatedMenu);
    }

    @DeleteMapping("/id")
    public void deleteMenu(@PathVariable String menuId){
        menuService.deleteMenu(menuId);
    }
}
