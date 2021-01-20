package com.github.slisowski.Spring_shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Objects;

@Entity
public class ShoppingListProduct {

    @EmbeddedId
    @JsonIgnore
    private ShoppingListProductPK pk;



    public ShoppingListProduct() {
        super();
    }



    public ShoppingListProduct(Product product, ShoppingList shoppingList) {

        pk = new ShoppingListProductPK();
        pk.setProduct(product);

        pk.setShoppingList(shoppingList);

    }

    @Transient
    public Product getProduct() {
        return this.pk.getProduct();
    }


    ShoppingListProductPK getPk() {
        return pk;
    }

    void setPk(final ShoppingListProductPK pk) {
        this.pk = pk;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ShoppingListProduct that = (ShoppingListProduct) o;
        return Objects.equals(pk, that.pk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk);
    }
}
