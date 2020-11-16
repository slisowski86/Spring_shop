package com.github.slisowski.Spring_shop.model.projection;

import com.github.slisowski.Spring_shop.model.Category;

import java.util.Set;
import java.util.stream.Collectors;

public class CategoryReadModel {
    private String name;
    private String description;
    private Set<CategoryProductReadModel> products;


    public CategoryReadModel(Category source){
        name = source.getName();
        description= source.getDescription();
        products = source.getProducts()
                .stream()
                .map(CategoryProductReadModel::new)
                .collect(Collectors.toSet());
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

    public Set<CategoryProductReadModel> getProducts() {
        return products;
    }

    public void setProducts(Set<CategoryProductReadModel> products) {
        this.products = products;
    }
}
