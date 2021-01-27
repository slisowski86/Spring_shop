package com.github.slisowski.Spring_shop.logic.servicerepo;


import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ShoppingList;


public interface ShoppingListRepoService extends JpaService<ShoppingList, Long> {


    void addProduct(Product product, ShoppingList currentList);
}
