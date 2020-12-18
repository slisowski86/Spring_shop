package com.github.slisowski.Spring_shop.model.projection;

import com.github.slisowski.Spring_shop.model.Product;

public class ListProductReadModel {
    private String name;
    private boolean bought;

    public ListProductReadModel(Product source){
        name= source.getName();
        bought= source.isBought();

    }
    public String getName() {
        return name;
    }

    public void setName (final String description) {
        this.name = description;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(final boolean bought) {
        this.bought = bought;
    }


}
