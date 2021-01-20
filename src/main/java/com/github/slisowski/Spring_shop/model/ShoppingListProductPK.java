package com.github.slisowski.Spring_shop.model;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable
class ShoppingListProductPK implements Serializable {
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="shoppinglist_id")
    private ShoppingList shoppingList;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;


    ShoppingList getShoppingList() {
        return shoppingList;
    }

    void setShoppingList(final ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    Product getProduct() {
        return product;
    }

    void setProduct(final Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ShoppingListProductPK that = (ShoppingListProductPK) o;
        return shoppingList.equals(that.shoppingList) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((shoppingList.getId() == null)
                ? 0
                : shoppingList
                .getId()
                .hashCode());
        result = prime * result + ((product.getId() == null)
                ? 0
                : product
                .getId()
                .hashCode());

        return result;
    }
}
