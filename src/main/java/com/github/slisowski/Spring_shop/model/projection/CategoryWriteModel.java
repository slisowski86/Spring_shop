package com.github.slisowski.Spring_shop.model.projection;

import com.github.slisowski.Spring_shop.model.Category;

public class CategoryWriteModel {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category toCategory(){
        var result = new Category();
        result.setName(name);
        result.setDescription(description);


        return result;
    }
}
