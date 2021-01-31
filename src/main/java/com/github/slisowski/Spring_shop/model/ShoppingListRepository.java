package com.github.slisowski.Spring_shop.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {








}
