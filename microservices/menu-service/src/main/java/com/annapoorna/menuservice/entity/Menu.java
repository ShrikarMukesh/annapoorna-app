package com.annapoorna.menuservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Document(collection = "menu-items")
public class Menu {

    @Id
    private String menuId;

    private String restaurantId;
    private List<MenuItem> items;
    private  String category;

}
