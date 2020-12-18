package com.github.slisowski.Spring_shop.adapter;

import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import com.github.slisowski.Spring_shop.model.ShoppingList;
import com.github.slisowski.Spring_shop.model.ShoppingListRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
interface SqlShoppingListRepository extends ShoppingListRepository, JpaRepository<ShoppingList, Integer> {

    @Override
    @Query("from ShoppingList l join fetch l.products")
    List<ShoppingList> findAll();
}
