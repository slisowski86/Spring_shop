package com.github.slisowski.Spring_shop.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name="products")

public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String name;
    private double price;

    @OneToMany(mappedBy = "product", cascade ={CascadeType.MERGE, CascadeType.PERSIST})
    List<ShoppingListProduct> shoppingListProducts=new ArrayList<>();





    @Embedded
    private Audit audit = new Audit();

    public Long getId() {
        return id;
    }

    public  void setId(final Long id) {
        this.id = id;
    }

    public  String getDescription() {
        return description;
    }

    public  void setDescription(final String description) {
        this.description = description;
    }

    public  String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public List<ShoppingListProduct> getShoppingListProducts() {
        return shoppingListProducts;
    }

    public void setShoppingListProducts(final List<ShoppingListProduct> shoppingListProducts) {
        this.shoppingListProducts = shoppingListProducts;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(final Audit audit) {
        this.audit = audit;
    }

    public Product(String name, String description) {

        this.name = name;
        this.description = description;


    }



}
