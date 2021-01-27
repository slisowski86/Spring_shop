package com.github.slisowski.Spring_shop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

class ShoppingListProductPK implements Serializable {

    @Column(name="product_id")
    Long productId;

    @Column(name="shoppingList_id")
    Long shoppingListId;



    ShoppingListProductPK(final Long productId, final Long shoppingListId) {
        this.productId = productId;
        this.shoppingListId = shoppingListId;
    }

    public ShoppingListProductPK() {

    }

    Long getProductId() {
        return productId;
    }

    void setProductId(final Long productId) {
        this.productId = productId;
    }

    Long getShoppingListId() {
        return shoppingListId;
    }

    void setShoppingListId(final Long shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingListProductPK)) return false;
        final ShoppingListProductPK that = (ShoppingListProductPK) o;
        return productId.equals(that.productId) && shoppingListId.equals(that.shoppingListId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, shoppingListId);
    }
}
