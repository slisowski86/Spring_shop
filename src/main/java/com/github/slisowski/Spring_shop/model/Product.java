package com.github.slisowski.Spring_shop.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Table(name="products")

public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String description;
    @NotBlank(message = "nazwa produktu nie może być pusta")
    private String name;
    private double price;

    @ManyToMany(mappedBy = "products")
    private List<ShoppingList> shoppingLists;


    private boolean bought;

    @Embedded
    private Audit audit = new Audit();




    public Product() {

    }

    public Product(String name, String description) {

        this.name = name;
        this.description = description;


    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(final boolean bought) {
        this.bought = bought;
    }

    public void updateFrom(final Product source) {
        description = source.description;
        name = source.name;
        price = source.price;
        bought = source.bought;

    }





}
