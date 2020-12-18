package com.github.slisowski.Spring_shop.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();
    Optional<Product> findById(Integer id);

    boolean existsById(Integer id);
    boolean existsByBoughtIsFalseAndShoppingLists_Id(Integer id);
    Product save (Product entity);

    Page<Product> findAll(Pageable page);
    List<Product> findProductByName(@Param("name") String name );

    List<Product> findProductByBought(boolean bought);


    List<Product> findAllByShoppingLists_Id(Integer listId);
}
