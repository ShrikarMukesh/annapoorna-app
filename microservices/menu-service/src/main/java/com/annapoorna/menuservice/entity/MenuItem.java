package com.annapoorna.menuservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;


@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class MenuItem {

    @Id
    private String itemId;

    private String name;
    private String description;
    private double price;
    private boolean available;
    private String category;

}
