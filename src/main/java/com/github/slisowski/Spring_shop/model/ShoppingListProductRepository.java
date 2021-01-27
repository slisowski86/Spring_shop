package com.github.slisowski.Spring_shop.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingListProductRepository extends JpaRepository<ShoppingListProduct, ShoppingListProductPK> {

    List<ShoppingListProduct> findShoppingListProductsByShoppingList_Id(Long id);


}
