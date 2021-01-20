package com.github.slisowski.Spring_shop.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListProductRepository extends JpaRepository<ShoppingListProduct, ShoppingListProductPK> {
}
