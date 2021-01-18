package com.github.slisowski.Spring_shop.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Setter
@Getter

@AllArgsConstructor
@Entity
@Table(name="shopping_list")
public class ShoppingList extends BaseModel {


    private boolean completed;

    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="shopping_list_products",
            joinColumns = @JoinColumn(name = "shopping_list_id"),
            inverseJoinColumns = @JoinColumn(name="product_id"))
    private Set<Product> products = new HashSet<>();



    private LocalDateTime dateCreate;

    public ShoppingList(){


    }


    @Builder
    public ShoppingList(boolean completed,Long id, String name, Set<Product> products, LocalDateTime dateCreate ) {
        this.completed=completed;
        this.name=name;
        this.products=products;
        this.dateCreate=dateCreate;

    }





}
