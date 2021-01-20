package com.github.slisowski.Spring_shop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@Table(name="shopping_list")
public class ShoppingList  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean completed;

    private String name;
    @OneToMany(mappedBy = "pk.shoppingList", cascade = CascadeType.PERSIST)

    private List<ShoppingListProduct> shoppingListProducts = new ArrayList<>();



    private LocalDateTime dateCreate;

    public ShoppingList(){


    }


    @Builder
    public ShoppingList(boolean completed,Long id, String name, List<ShoppingListProduct> shoppingListProducts, LocalDateTime dateCreate ) {
        this.completed=completed;
        this.name=name;
        this.shoppingListProducts=shoppingListProducts;
        this.dateCreate=dateCreate;

    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(final boolean completed) {
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<ShoppingListProduct> getShoppingListProducts() {
        return shoppingListProducts;
    }

    public void setShoppingListProducts(final List<ShoppingListProduct> shoppingListProducts) {
        this.shoppingListProducts = shoppingListProducts;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(final LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }
}
