package com.github.slisowski.Spring_shop.model.projection;

import com.github.slisowski.Spring_shop.model.Category;
import com.github.slisowski.Spring_shop.model.Product;

public class CategoryProductReadModel {

    private String description;

    private String name;
    private double price;
    private Category category;

    public CategoryProductReadModel(Product source){
        description= source.getDescription();
        name= source.getName();
        price= source.getPrice();
        category =source.getCategory();
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
