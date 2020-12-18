package com.github.slisowski.Spring_shop.model.projection;

import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ShoppingList;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ListReadModel {
    private int id;
    private String name;
    private boolean completed;
    private List<ListProductReadModel> products;



    private LocalDateTime dateCreate;

    public ListReadModel(ShoppingList source) {
        id= source.getId();
        name = source.getName();
        products=source.getProducts().stream()
                .map(ListProductReadModel::new)
                .collect(Collectors.toList());


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

    public List<ListProductReadModel> getProducts() {
        return products;
    }

    public void setProducts(final List<ListProductReadModel> products) {
        this.products = products;
    }


}
