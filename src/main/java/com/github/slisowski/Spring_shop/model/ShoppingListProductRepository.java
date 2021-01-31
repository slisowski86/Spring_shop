package com.github.slisowski.Spring_shop.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShoppingListProductRepository extends JpaRepository<ShoppingListProduct, ShoppingListProductPK> {

    List<ShoppingListProduct> findShoppingListProductsByShoppingList_Id(Long id);


}
