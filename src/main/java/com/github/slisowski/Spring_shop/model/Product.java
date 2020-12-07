package com.github.slisowski.Spring_shop.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Entity
@Table(name="products")

public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Product description must not be empty")
    private String description;

    private String name;
    private double price;




    public Product() {

    }

    public Product(@NotBlank(message = "Product description must not be empty") String description, String name, double price) {
        this.description = description;
        this.name = name;
        this.price = price;

    }



    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
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




    public void updateFrom(final Product source){
        description=source.description;
        name = source.name;
        price= source.price;


    }


}
