package com.github.slisowski.Spring_shop.dto;

import com.github.slisowski.Spring_shop.model.Product;

public class ShoppingListProductDto {
    private Product product;
    private Integer quantity;

    Product getProduct() {
        return product;
    }

    void setProduct(final Product product) {
        this.product = product;
    }

    Integer getQuantity() {
        return quantity;
    }

    void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }


}
