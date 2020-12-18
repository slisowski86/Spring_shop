package com.github.slisowski.Spring_shop.model.projection;

import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ShoppingList;

class ListProductWriteModel {



    private String name;
    private String description;



    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Product toProduct(final ShoppingList list){
        return new Product(name, description);
    }
}
