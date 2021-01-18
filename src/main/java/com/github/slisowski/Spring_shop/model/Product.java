package com.github.slisowski.Spring_shop.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")

public class Product extends BaseModel {


    private String description;

    private String name;
    private double price;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private Set<ShoppingList> shoppingLists = new HashSet<>();


    private boolean bought;

    @Embedded
    private Audit audit = new Audit();





    @Builder
    public Product(Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;


    }





}
