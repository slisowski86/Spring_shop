package com.github.slisowski.Spring_shop.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ShoppingListRepository {

    List<ShoppingList> findAll();
    Optional<ShoppingList> findById(Integer id);

    boolean existsById(Integer id);



    Optional<List<ShoppingList>> findShoppingListByDateCreate(LocalDateTime date);

    ShoppingList save(ShoppingList entity);
}
