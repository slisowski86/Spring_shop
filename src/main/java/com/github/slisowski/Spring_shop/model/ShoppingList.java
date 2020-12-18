package com.github.slisowski.Spring_shop.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="shopping_list")
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean completed;
    private String name;
    @ManyToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name="shopping_list_products",
            joinColumns = @JoinColumn(name = "shopping_list_id"),
            inverseJoinColumns = @JoinColumn(name="product_id"))
    private List<Product> products;



    private LocalDateTime dateCreate;



    public ShoppingList() {
    }



    public int getId() {
        return id;
    }



    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(final boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(final LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }
}
