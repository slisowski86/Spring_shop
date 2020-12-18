package com.github.slisowski.Spring_shop.model.projection;

import com.github.slisowski.Spring_shop.model.ShoppingList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListWriteModel {
    private String name;
    private List<ListProductWriteModel> products = new ArrayList<>();


    public ListWriteModel(){
        products.add(new ListProductWriteModel());
    }
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<ListProductWriteModel> getProducts() {
        return products;
    }

    public void setProducts(final List<ListProductWriteModel> products) {
        this.products = products;
    }

    public ShoppingList toShoppingList(){
        var result = new ShoppingList();
        result.setName(name);
        result.setProducts(products.stream()
                            .map(source->source.toProduct(result))
                                .collect(Collectors.toList()));
        return result;


    }
}
