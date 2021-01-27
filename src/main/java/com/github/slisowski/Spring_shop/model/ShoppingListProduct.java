package com.github.slisowski.Spring_shop.model;

import javax.persistence.*;

@Entity
public class ShoppingListProduct {

    @EmbeddedId
    ShoppingListProductPK id;


    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @MapsId("shoppingListId")
    @JoinColumn(name="shoppinglist_id")
    private ShoppingList shoppingList;




    public ShoppingListProduct() {

    }



    public ShoppingListProduct(ShoppingList shoppingList, Product product) {

        this.id=new ShoppingListProductPK(shoppingList.getId(), product.getId());

        this.shoppingList=shoppingList;
        this.product=product;

    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(final ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }


}
