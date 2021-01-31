package com.github.slisowski.Spring_shop.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="shopping_list")

public class ShoppingList  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean completed;

    private String name;
    @OneToMany(mappedBy = "shoppingList",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    List<ShoppingListProduct> shoppingListProducts=new ArrayList<>();



    private LocalDateTime dateCreate;

    public ShoppingList(){



    }





    public ShoppingList(boolean completed, String name, List<ShoppingListProduct> shoppingListProducts, LocalDateTime dateCreate ) {
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